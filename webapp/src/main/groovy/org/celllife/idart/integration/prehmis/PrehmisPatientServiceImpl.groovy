package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientBuilder
import org.celllife.idart.domain.patient.PatientIdentifierType
import org.celllife.idart.integration.prehmis.builder.GetPatientRequestBuilder
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.springframework.util.Assert.notNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Service("prehmisPatientService")
class PrehmisPatientServiceImpl implements PrehmisPatientService, InitializingBean {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    @Value('${prehmis.endpoint.url}')
    String prehmisEndpointUrl;

    @Value('${prehmis.username}')
    String prehmisUsername;

    @Value('${prehmis.password}')
    String prehmisPassword;

    @Value('${prehmis.applicationKey}')
    String prehmisApplicationKey;

    RESTClient prehmisRestClient

    @Override
    Set<Patient> findByIdentifier(String clinicIdentifierValue, String patientIdentifierValue) {

        Set<Patient> patients = []

        for (PrehmisPatientIdentifierType patientIdentifierType : PrehmisPatientIdentifierType.values()) {
            def patient = getPatient(clinicIdentifierValue, patientIdentifierValue, patientIdentifierType.getType())
            if (patient != null) {
                patients << patient
            }
        }

        patients
    }

    Patient getPatient(String clinicIdentifierValue, String patientIdentifierValue, String patientIdentifierType) {

        String getPatientRequest =
            buildGetPatientRequest(clinicIdentifierValue, patientIdentifierValue, patientIdentifierType)

        def getPatientResponse = prehmisRestClient.post(
                body: getPatientRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                        SOAPAction: "http://prehmis-qa.capetown.gov.za/getPatient"
                ]
        )

        return buildPatient(getPatientResponse)
    }

    private String buildGetPatientRequest(String clinicIdentifierValue,
                                          String patientIdentifierValue,
                                          String patientIdentifierType) {

        def getPatientRequest = new GetPatientRequestBuilder()
                .setUsername(prehmisUsername)
                .setPassword(prehmisPassword)
                .setApplicationKey(prehmisApplicationKey)
                .setFacilityCode(clinicIdentifierValue)
                .setPatientIdentifierValue(patientIdentifierValue)
                .setPatientIdentifierType(patientIdentifierType)
                .build()
        getPatientRequest
    }

    private Patient buildPatient(getPatientResponse) {

        def envelope = getPatientResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def patient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        PatientBuilder builder = new PatientBuilder()

        String prehmisId = patient.id.text()
        if (prehmisId == null || prehmisId.isEmpty()) {
            return null
        }

        builder.addIdentifier(prehmisId, PatientIdentifierType.PREHMIS)

        String pgwcPatientNumber = patient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.isEmpty()) {
            builder.addIdentifier(pgwcPatientNumber, PatientIdentifierType.PGWC)
        }

        String saId = patient.sa_id_number.text()
        if (saId != null && !saId.isEmpty()) {
            builder.addIdentifier(saId, PatientIdentifierType.SAID)
        }

        builder.build()
    }

    @Override
    void afterPropertiesSet() throws Exception {

        notNull(prehmisEndpointUrl)

        notNull(prehmisUsername)

        notNull(prehmisPassword)

        notNull(prehmisApplicationKey)

        prehmisRestClient = new RESTClient(prehmisEndpointUrl)
    }
}
