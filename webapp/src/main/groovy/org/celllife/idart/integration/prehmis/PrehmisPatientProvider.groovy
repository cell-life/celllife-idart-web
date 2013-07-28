package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.patient.PatientProvider
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.PatientBuilder.buildIdartPatient
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildGetPatientRequest
import static org.springframework.util.Assert.notNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Service class PrehmisPatientProvider implements PatientProvider, InitializingBean {

    @Value('${prehmis.endpoint.url}')
    String prehmisEndpointUrl

    @Value('${prehmis.username}')
    String prehmisUsername

    @Value('${prehmis.password}')
    String prehmisPassword

    @Value('${prehmis.applicationKey}')
    String prehmisApplicationKey

    RESTClient prehmisRestClient

    @Override
    Set<Patient> findByIdentifier(String clinicIdentifierValue, String patientIdentifierValue) {

        Set<Patient> patients = []

        PrehmisPatientIdentifierType.values().each { patientIdentifierType ->

            def patient = getPatient(clinicIdentifierValue, patientIdentifierValue, patientIdentifierType)
            if (patient != null) {
                patients << patient
            }
        }

        patients
    }

    Patient getPatient(String clinicIdentifierValue, String patientIdentifierValue, PrehmisPatientIdentifierType patientIdentifierType) {

        String getPatientRequest = buildGetPatientRequest(
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: clinicIdentifierValue,
                patientIdentifierValue: patientIdentifierValue,
                patientIdentifierType: patientIdentifierType.toString().toLowerCase()
        )

        def getPatientResponse = prehmisRestClient.post(
                body: getPatientRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                        SOAPAction: "http://prehmis-qa.capetown.gov.za/getPatient"
                ]
        )

        return buildIdartPatient(getPatientResponse.data)
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
