package org.celllife.idart.integration.prehmis

import groovyx.net.http.RESTClient
import org.celllife.idart.application.patient.PatientProvider
import org.celllife.idart.integration.prehmis.builder.GetPatientRequestBuilder
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.PatientBuilder.buildIdartPatient
import static org.springframework.util.Assert.notNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Service("prehmisPatientProvider")
class PrehmisPatientProvider implements PatientProvider, InitializingBean {

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

        PrehmisPatientIdentifierType.values().each { patientIdentifierType ->

            def patient = getPatient(clinicIdentifierValue, patientIdentifierValue, patientIdentifierType)
            if (patient != null) {
                patients << patient
            }
        }

        patients
    }

    Patient getPatient(String clinicIdentifierValue, String patientIdentifierValue, PrehmisPatientIdentifierType patientIdentifierType) {

        String getPatientRequest = new GetPatientRequestBuilder()
                .setUsername(prehmisUsername)
                .setPassword(prehmisPassword)
                .setApplicationKey(prehmisApplicationKey)
                .setFacilityCode(clinicIdentifierValue)
                .setPatientIdentifierValue(patientIdentifierValue)
                .setPatientIdentifierType(patientIdentifierType)
                .build()

//        def getPatientResponse = prehmisRestClient.post(
//                body: getPatientRequest,
//                contentType: ContentType.XML,
//                requestContentType: ContentType.XML,
//                headers: [
//                        SOAPAction: "http://prehmis-qa.capetown.gov.za/getPatient"
//                ]
//        )

        return buildIdartPatient(new XmlSlurper().parseText(xml))
    }

    @Override
    void afterPropertiesSet() throws Exception {

        notNull(prehmisEndpointUrl)

        notNull(prehmisUsername)

        notNull(prehmisPassword)

        notNull(prehmisApplicationKey)

        prehmisRestClient = new RESTClient(prehmisEndpointUrl)

    }

    def xml = """<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
                   xmlns:ns1="http://prehmis-qa.capetown.gov.za/"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <SOAP-ENV:Header>
        <ns1:AuthHeaderElement xsi:type="ns1:AuthHeader">
            <username></username>
            <password></password>
            <facility_code></facility_code>
            <application_key></application_key>
        </ns1:AuthHeaderElement>
    </SOAP-ENV:Header>
    <SOAP-ENV:Body>
        <ns1:getPatientResponse>
            <result>
                <id>1</id>
                <first_name>AEIGHT</first_name>
                <last_name>TEST</last_name>
                <date_of_birth>1981-01-01</date_of_birth>
                <gender>Male</gender>
                <cellphone_number/>
                <pgwc_patient_number>72254311</pgwc_patient_number>
                <sa_id_number/>
                <passport_number/>
            </result>
        </ns1:getPatientResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>"""

}
