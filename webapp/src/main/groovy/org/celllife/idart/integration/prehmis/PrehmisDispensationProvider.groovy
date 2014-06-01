package org.celllife.idart.integration.prehmis

import static org.celllife.idart.common.IdentifiableType.*
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartClassificationApplications.getClassificationCode
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildApiLoginRequest
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildDeleteDispensationRequest
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildStoreDispensationRequest
import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

import java.text.SimpleDateFormat

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.dispensation.DispensationNotDeletedException
import org.celllife.idart.application.dispensation.DispensationNotSavedException
import org.celllife.idart.application.dispensation.DispensationProvider
import org.celllife.idart.datawarehouse.prescription.PrescriptionDataWarehouse
import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.dispensation.DispensationService
import org.celllife.idart.domain.eventerror.EventError
import org.celllife.idart.domain.eventerror.EventErrorService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.part.PartService
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.product.ProductService
import org.celllife.idart.framework.aspectj.LogLevel
import org.celllife.idart.framework.aspectj.Loggable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * The PREHMIS implementation for the DispensationProvider related events
 */
@Service @Named class PrehmisDispensationProvider implements DispensationProvider {

    static final Logger LOGGER = LoggerFactory.getLogger(PrehmisDispensationProvider)

    String SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'
	
    @Value('${prehmis.namespace}')
    String prehmisNamespace
    
	@Value('${prehmis.endpoint.baseUrl}')
	String prehmisEndpointBaseUrl

    @Value('${prehmis.endpoint.url}')
	String prehmisEndpointUrl

    @Value('${prehmis.username}')
	String prehmisUsername

    @Value('${prehmis.password}')
	String prehmisPassword

    @Value('${prehmis.applicationKey}')
	String prehmisApplicationKey

    @Inject IdentifiableService identifiableService

    @Inject PatientService patientService

    @Inject PersonService personService

    @Inject PractitionerService practitionerService

    @Inject PrescriptionDataWarehouse prescriptionDataWarehouse

    @Inject ProductService productService

    @Inject PartService partService
    
    @Inject DispensationService dispensationService
    
    @Inject EventErrorService eventErrorService
    
    @Override
    @Loggable(LogLevel.INFO)
    void processEvent(DispensationEvent dispensationEvent) {
        if (dispensationEvent.type == DispensationEvent.EventType.SAVED) {
            save(dispensationEvent)
        } else if (dispensationEvent.type == DispensationEvent.EventType.DELETED) {
            delete(dispensationEvent)
        } else {
            String errorMessage = "Could not process DispensationEvent with type "+dispensationEvent.type
            LOGGER.warn(errorMessage)
            saveEventError(errorMessage, dispensationEvent)
        }
    }

    void save(DispensationEvent dispensationEvent) {

       def prehmisFacilityIdentifier = getFacilityIdentifiable(dispensationEvent)
        if (prehmisFacilityIdentifier == null) {
            return
        }

        def prehmisRestClient = new RESTClient(prehmisEndpointUrl)
        def storeDispensationRequest
        def storeDispensationResponse
        
        try {
            storeDispensationRequest = buildStoreDispensationRequest(prehmisFacilityIdentifier, dispensationEvent.dispensation)
        } catch (Exception e) {
            String errorMessage = "Unable to create storedispensation request for dispensation '"+dispensationEvent.dispensation.id+"'. Error: "+e.message
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotSavedException(errorMessage, e)
        }
        
        try {
            apiLogin(prehmisRestClient, prehmisFacilityIdentifier)

            storeDispensationResponse = prehmisRestClient.post(
                    body: storeDispensationRequest,
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                        SOAPAction: prehmisEndpointBaseUrl + "/storeDispensation"
                    ]
                    )
        } catch (Exception e) {
            String errorMessage = "Unable to communicate with PREHMIS while trying to store dispensation '"+dispensationEvent.dispensation.id+"'. Error: "+e.message
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotSavedException(errorMessage, e)
        }

        def result = storeDispensationResponse.data
        LOGGER.info("PREHMIS response: "+result)
        if (!result.equals("Dispensation saved")) {
            String errorMessage = "Unable to store dispensation '"+dispensationEvent.dispensation.id+"' on PREHMIS. Error: "+result
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotSavedException(errorMessage)
        }
    }
    
    void delete(DispensationEvent dispensationEvent) {
        def prehmisFacilityIdentifier = getFacilityIdentifiable(dispensationEvent)
        if (prehmisFacilityIdentifier == null) {
            return
        }

        def prehmisRestClient = new RESTClient(prehmisEndpointUrl)
        def deleteDispensationRequest
        def deleteDispensationResponse
        
        try {
            deleteDispensationRequest = buildDeleteDispensationRequest(prehmisFacilityIdentifier, dispensationEvent.dispensation)
        } catch (Exception e) {
            String errorMessage = "Unable to create deletedispensation request for dispensation '"+dispensationEvent.dispensation.id+"'. Error: "+e.message
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotDeletedException(errorMessage, e)
        }

        try {
            apiLogin(prehmisRestClient, prehmisFacilityIdentifier)

            deleteDispensationResponse = prehmisRestClient.post(
                    body: deleteDispensationRequest,
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                        SOAPAction: prehmisEndpointBaseUrl + "/deleteDispensation"
                    ]
                    )
        } catch (Exception e) {
            String errorMessage = "Unable to communicate with PREHMIS while trying to delete dispensation '"+dispensationEvent.dispensation.id+"'. Error: "+e.message
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotDeletedException(errorMessage, e)
        }

        def result = deleteDispensationResponse.data
        LOGGER.info("PREHMIS response: "+result)
        if (!result.equals("Dispensation deleted")) {
            String errorMessage = "Unable to delete dispensation '"+dispensationEvent.dispensation.id+"' on PREHMIS. Error: "+result
            saveEventError(errorMessage, dispensationEvent)
            throw new DispensationNotDeletedException(errorMessage)
        }
    }

    def saveEventError(String message, DispensationEvent event) {
        EventError eventError = new EventError();
        eventError.with {
            datetime = new Date()
            retryCount = 0
            errorMessage = message
            eventType = EventError.EventType.DISPENSATION_EVENT
            eventUuid = event.uuid
        }
        eventError.setUnserializedEventObject(event)
        eventErrorService.save(eventError)
    }
    
    String buildStoreDispensationRequest(String facilityCode, Dispensation dispensation) {

        String storeDispensationRequest = buildStoreDispensationRequest([
            xmlnsPreh: prehmisNamespace,
            username: prehmisUsername,
            password: prehmisPassword,
            applicationKey: prehmisApplicationKey,
            facilityCode: facilityCode,
            dispensation: getPrehmisDispensationMap(facilityCode, dispensation, true)
        ])

        storeDispensationRequest
    }
        
    String buildDeleteDispensationRequest(String facilityCode, Dispensation dispensation) {

        String deleteDispensationRequest = buildDeleteDispensationRequest([
            xmlnsPreh: prehmisNamespace,
            username: prehmisUsername,
            password: prehmisPassword,
            applicationKey: prehmisApplicationKey,
            facilityCode: facilityCode,
            dispensation: getPrehmisDispensationMap(facilityCode, dispensation, false)
        ])

        deleteDispensationRequest
    }
    
    Map<String, Object> getPrehmisDispensationMap(String facilityCode, Dispensation dispensation, boolean includeDrugs) {
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
                    
                    if (includeDrugs) {
                        def medication = productService.findByProductId(dispensedMedication.medication)
                        def drug = partService.findByPartId((medication as Medication).drug)
    
                        [
                                atcCode: getClassificationCode(drug.classifications, ATC),
                                quantity: dispensedMedication.quantity?.value,
                        ]
                    }
                }
            }
        }

        prehmisDispensation
    }
    
    String getFacilityIdentifiable(DispensationEvent dispensationEvent) {
        def facilityIdentifiable =
                identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(dispensationEvent.dispensation.facility.value))

        return getIdentifierValue(facilityIdentifiable.identifiers, PREHMIS.id)
    }

    void apiLogin(RESTClient prehmisRestClient, String prehmisFacilityIdentifier) throws Exception {
        def apiLoginRequest = buildApiLoginRequest([
            xmlnsPreh: prehmisNamespace,
            username: prehmisUsername,
            password: prehmisPassword,
            applicationKey: prehmisApplicationKey,
            facilityCode: prehmisFacilityIdentifier,
        ])

        prehmisRestClient.post(
                body: apiLoginRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                    SOAPAction: prehmisEndpointBaseUrl + "/apiLogin"
                ]
                )
    }

    static toPrehmisDate(Date date) {

        if (date == null) {
            return null
        }

        new SimpleDateFormat("yyyy-MM-dd").format(date)
    }
}
