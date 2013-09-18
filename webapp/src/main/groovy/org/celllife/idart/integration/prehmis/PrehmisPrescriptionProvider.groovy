package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.prescription.PrescriptionNotSavedException
import org.celllife.idart.application.prescription.PrescriptionProvider
import org.celllife.idart.domain.encounter.EncounterService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.part.PartService
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.product.ProductService
import org.springframework.beans.factory.annotation.Value

import javax.inject.Inject
import javax.inject.Named
import java.text.SimpleDateFormat

import static org.celllife.idart.common.IdentifiableType.*
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartClassificationApplications.getClassificationCode
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildApiLoginRequest
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildStorePrescriptionRequest

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Named class PrehmisPrescriptionProvider implements PrescriptionProvider {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    @Value('${prehmis.endpoint.url}') String prehmisEndpointUrl

    @Value('${prehmis.username}') String prehmisUsername

    @Value('${prehmis.password}') String prehmisPassword

    @Value('${prehmis.applicationKey}') String prehmisApplicationKey

    @Inject IdentifiableService identifiableService

    @Inject EncounterService encounterService

    @Inject PatientService patientService

    @Inject PersonService personService

    @Inject PractitionerService practitionerService

    @Inject PrescribedMedicationService prescribedMedicationService

    @Inject ProductService productService

    @Inject PartService partService

    @Override
    void save(PrescriptionEvent prescriptionEvent) {

        def encounter = encounterService.findByEncounterId(prescriptionEvent.prescription.encounter)

        def facilityIdentifiable =
            identifiableService.resolveIdentifiable(FACILITY, [newIdentifier(IDART_WEB.id, encounter.facility.value)] as Set)

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
            throw new PrescriptionNotSavedException(e.message)
        }

        def storePrescriptionResponse

        try {
            storePrescriptionResponse = prehmisRestClient.post(
                    body: buildStorePrescriptionRequest(prehmisFacilityIdentifier, prescriptionEvent.prescription),
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                            SOAPAction: "http://prehmis-qa.capetown.gov.za/storePrescription"
                    ]
            )
        } catch (Exception e) {
            throw new PrescriptionNotSavedException(e.message)
        }

        def envelope = storePrescriptionResponse.data

        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        String result = envelope.'soap:Body'.'prehmis:storePrescriptionResponse'.result

        if (!result.equals("Prescription saved")) {
            throw new PrescriptionNotSavedException(result)
        }
    }

    String buildStorePrescriptionRequest(String facilityCode, Prescription prescription) {

        def prehmisPrescription = [:]

        prescription.with {

            def prescriptionIdentifiable = identifiableService
                    .resolveIdentifiable(PRESCRIBED_MEDICATION, [newIdentifier(IDART_WEB.id, prescription.id.value)] as Set)

            prehmisPrescription.id = getIdentifierValue(prescriptionIdentifiable.identifiers, IDART_WEB.id)

            def patient = patientService.findByPatientId(prescription.patient)
            def patientIdentifiable = identifiableService
                    .resolveIdentifiable(PATIENT, [newIdentifier(IDART_WEB.id, patient.id.value)] as Set)

            prehmisPrescription.prehmisPatientId = getIdentifierValue(patientIdentifiable?.identifiers, PREHMIS.id)
            prehmisPrescription.pgwcPatientNumber = getIdentifierValue(patientIdentifiable?.identifiers, PGWC.id)

            def person = personService.findByPersonId(patient.person)
            def personIdentifiable = identifiableService
                    .resolveIdentifiable(PERSON, [newIdentifier(IDART_WEB.id, person.id.value)] as Set)

            prehmisPrescription.patientSaIdNumber = getIdentifierValue(personIdentifiable?.identifiers, SA_IDENTITY_NUMBER.id)

            def prescriber = practitionerService.findByPractitionerId(prescription.prescriber)
            def prescriberIdentifiable = identifiableService
                    .resolveIdentifiable(PRACTITIONER, [newIdentifier(IDART_WEB.id, prescriber.id.value)] as Set)

            prehmisPrescription.practitionerCode = getIdentifierValue(prescriberIdentifiable?.identifiers, PREHMIS.id)

            prehmisPrescription.prescriptionDate = toPrehmisDate(dateWritten)

            if (prescribedMedications.size() != 0) {

                prehmisPrescription.prescribedMedications = prescribedMedications.collect { prescribedMedicationId ->

                    def prescribedMedication =
                        prescribedMedicationService.findByPrescribedMedicationId(prescribedMedicationId)

                    prescribedMedication
                    if (prehmisPrescription.endDate == null) {
                        prehmisPrescription.endDate = toPrehmisDate(prescribedMedication.valid?.thruDate)
                    }

                    if (prehmisPrescription.duration == null) {
                        prehmisPrescription.duration = prescribedMedication.expectedSupplyDuration?.value
                    }

                    if (prehmisPrescription.changeReason == null) {
                        prehmisPrescription.changeReason = prescribedMedication.reasonForPrescribing
                    }

                    def medication = productService.findByProductId(prescribedMedication.medication)

                    def drug = partService.findByPartId((medication as Medication).drug)

                    [
                            atcCode: getClassificationCode(drug.classifications, ATC),
                            amountPerTime: prescribedMedication.dosageInstruction?.doseQuantity?.value,
                            timesPerDay: prescribedMedication.dosageInstruction?.timing?.repeat?.frequency
                    ]
                }
            }
        }

        String storePrescriptionRequest = buildStorePrescriptionRequest([
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: facilityCode,
                prescription: prehmisPrescription
        ])

        storePrescriptionRequest
    }

    static toPrehmisDate(Date date) {

        if (date == null) {
            return null
        }

        new SimpleDateFormat("yyyy-MM-dd").format(date)
    }
}
