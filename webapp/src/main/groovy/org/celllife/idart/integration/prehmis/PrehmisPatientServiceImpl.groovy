package org.celllife.idart.integration.prehmis
import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.integration.prehmis.builder.GetPatientRequestBuilder
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.IdartPatientBuilder.buildIdartPatient
import static org.springframework.util.Assert.notNull
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Service("prehmisPatientService")
class PrehmisPatientServiceImpl implements PrehmisPatientService, InitializingBean {


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
            def patient = getPatient(clinicIdentifierValue, patientIdentifierValue, patientIdentifierType.getPrehmisType())
            if (patient != null) {
                patients << patient
            }
        }

        patients
    }

    Patient getPatient(String clinicIdentifierValue, String patientIdentifierValue, String patientIdentifierType) {

        String getPatientRequest = new GetPatientRequestBuilder()
                .setUsername(prehmisUsername)
                .setPassword(prehmisPassword)
                .setApplicationKey(prehmisApplicationKey)
                .setFacilityCode(clinicIdentifierValue)
                .setPatientIdentifierValue(patientIdentifierValue)
                .setPatientIdentifierType(patientIdentifierType)
                .build()

        def getPatientResponse = prehmisRestClient.post(
                body: getPatientRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                        SOAPAction: "http://prehmis-qa.capetown.gov.za/getPatient"
                ]
        )

        return buildIdartPatient(getPatientResponse)
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
