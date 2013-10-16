package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.dispensation.DispensationNotSavedException
import org.celllife.idart.application.dispensation.DispensationProvider
import org.celllife.idart.datawarehouse.prescription.PrescriptionDataWarehouse
import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.part.PartService
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.product.ProductService
import org.celllife.idart.framework.aspectj.LogLevel
import org.celllife.idart.framework.aspectj.Loggable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value

import javax.inject.Inject
import javax.inject.Named
import java.text.SimpleDateFormat

import static org.celllife.idart.common.IdentifiableType.*
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartClassificationApplications.getClassificationCode
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildApiLoginRequest
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildStoreDispensationRequest

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Named class PrehmisDispensationProvider implements DispensationProvider {

    static final Logger LOGGER = LoggerFactory.getLogger(PrehmisDispensationProvider)

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    @Value('${prehmis.endpoint.url}') String prehmisEndpointUrl

    @Value('${prehmis.username}') String prehmisUsername

    @Value('${prehmis.password}') String prehmisPassword

    @Value('${prehmis.applicationKey}') String prehmisApplicationKey

    @Inject IdentifiableService identifiableService

    @Inject PatientService patientService

    @Inject PersonService personService

    @Inject PractitionerService practitionerService

    @Inject PrescriptionDataWarehouse prescriptionDataWarehouse

    @Inject ProductService productService

    @Inject PartService partService

    @Override
	@Loggable(LogLevel.INFO)
    void save(DispensationEvent dispensationEvent) {

        def facilityIdentifiable = identifiableService
                .resolveIdentifiable(FACILITY, newIdentifiers(dispensationEvent.dispensation.facility.value))

        def prehmisFacilityIdentifier = getIdentifierValue(facilityIdentifiable.identifiers, PREHMIS.id)
        if (prehmisFacilityIdentifier == null) {
            return
        }

        def prehmisRestClient = new RESTClient(prehmisEndpointUrl)

        def apiLoginRequest = buildApiLoginRequest([
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: prehmisFacilityIdentifier,
        ])

        try {
            prehmisRestClient.post(
                    body: apiLoginRequest,
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                            SOAPAction: "http://prehmis-qa.capetown.gov.za/apiLogin"
                    ]
            )
        } catch (Exception e) {
            LOGGER.error(e.message, e)
            throw new DispensationNotSavedException(e.message)
        }

        def storeDispensationResponse

        try {
            storeDispensationResponse = prehmisRestClient.post(
                    body: buildStoreDispensationRequest(prehmisFacilityIdentifier, dispensationEvent.dispensation),
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                            SOAPAction: "http://prehmis-qa.capetown.gov.za/storeDispensation"
                    ]
            )
        } catch (Exception e) {
            LOGGER.error(e.message, e)
            throw new DispensationNotSavedException(e.message)
        }

        def envelope = storeDispensationResponse.data

        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        String result = envelope.'soap:Body'.'prehmis:storeDispensationResponse'.result

        if (!result.equals("Dispensation saved")) {
            throw new DispensationNotSavedException(result)
        }
    }

    String buildStoreDispensationRequest(String facilityCode, Dispensation dispensation) {

        def prehmisDispensation = [:]

        dispensation.with {

            def dispensationIdentifiable = identifiableService
                    .resolveIdentifiable(PRESCRIBED_MEDICATION, newIdentifiers(dispensation.id.value))

            prehmisDispensation.id = getIdentifierValue(dispensationIdentifiable.identifiers, IDART_WEB.id)

            def patient = patientService.findByPatientId(dispensation.patient)
            def patientIdentifiable = identifiableService
                    .resolveIdentifiable(PATIENT, newIdentifiers(patient.id.value))

            prehmisDispensation.prehmisPatientId = getIdentifierValue(patientIdentifiable?.identifiers, PREHMIS.id)
            prehmisDispensation.pgwcPatientNumber = getIdentifierValue(patientIdentifiable?.identifiers, PGWC.id)

            def person = personService.findByPersonId(patient.person)
            def personIdentifiable = identifiableService
                    .resolveIdentifiable(PERSON, newIdentifiers(person.id.value))

            prehmisDispensation.patientSaIdNumber = getIdentifierValue(personIdentifiable?.identifiers, SA_IDENTITY_NUMBER.id)

            def dispenser = practitionerService.findByPractitionerId(dispensation.dispenser)
            def dispenserIdentifiable = identifiableService
                    .resolveIdentifiable(PRACTITIONER, newIdentifiers(dispenser.id.value))

            prehmisDispensation.practitionerCode = getIdentifierValue(dispenserIdentifiable?.identifiers, PREHMIS.id)

            prehmisDispensation.dispensationDate = toPrehmisDate(handedOver)

            if (dispensedMedications.size() != 0) {

                prehmisDispensation.dispensedMedications = dispensedMedications.collect { dispensedMedication ->

                    if (prehmisDispensation.prescription == null) {

                        def prescriptionId = prescriptionDataWarehouse
                                .findByPrescribedMedication(dispensedMedication.authorizingPrescribedMedication)

                        prehmisDispensation.prescription = prescriptionId.value

                    }

                    if (prehmisDispensation.supplyDuration == null) {
                        prehmisDispensation.supplyDuration = dispensedMedication.expectedSupplyDuration?.value
                    }

                    def medication = productService.findByProductId(dispensedMedication.medication)
                    def drug = partService.findByPartId((medication as Medication).drug)

                    [
                            atcCode: getClassificationCode(drug.classifications, ATC),
                            quantity: dispensedMedication.quantity?.value,
                    ]
                }
            }
        }

        String storeDispensationRequest = buildStoreDispensationRequest([
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: facilityCode,
                dispensation: prehmisDispensation
        ])

        storeDispensationRequest
    }

    static toPrehmisDate(Date date) {

        if (date == null) {
            return null
        }

        new SimpleDateFormat("yyyy-MM-dd").format(date)
    }
}
