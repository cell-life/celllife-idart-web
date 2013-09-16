package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.common.Gender
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber
import org.junit.Assert
import org.junit.Test

import java.text.SimpleDateFormat

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType.PGWC
import static org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType.PREHMIS

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 17h55
 */
class PatientBuilderTest {

    String xml =
        """<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
                   xmlns:ns1="http://prehmis-qa.capetown.gov.za/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
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
                <cellphone_number>0721234567</cellphone_number>
                <pgwc_patient_number>72254311</pgwc_patient_number>
                <sa_id_number/>
                <passport_number/>
            </result>
        </ns1:getPatientResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
"""

    @Test
    void shouldBuildIdartPatient() throws Exception {

        def envelope = new XmlSlurper().parseText(xml)
        def patient = PatientBuilder.buildIdartPatient(envelope)

        Assert.assertEquals("AEIGHT", patient.person.firstName)
        Assert.assertEquals("TEST", patient.person.lastName)
        Assert.assertEquals("72254311", getIdentifierValue(patient.identifiers, PGWC.authority))
        Assert.assertEquals("1", getIdentifierValue(patient.identifiers, PREHMIS.authority))
        Assert.assertEquals(Gender.MALE, patient.person.gender)
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("1981-01-01"), patient.person.birthDate)

        patient.person.contactMechanisms.each { contactMechanism ->
            if (contactMechanism.contactMechanism instanceof MobileTelephoneNumber) {
                Assert.assertEquals("27", ((MobileTelephoneNumber) contactMechanism.contactMechanism).countryCode)
                Assert.assertEquals("0721234567", ((MobileTelephoneNumber) contactMechanism.contactMechanism).contactNumber)
            }
        }
    }
}
