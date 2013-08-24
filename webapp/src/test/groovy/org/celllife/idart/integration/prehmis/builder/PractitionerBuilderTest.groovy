package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber
import org.junit.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 17h55
 */
class PractitionerBuilderTest {

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
        <ns1:getPractitionerResponse>
            <result>
                <id>1</id>
                <first_name>AEIGHT</first_name>
                <last_name>TEST</last_name>
                <date_of_birth>1981-01-01</date_of_birth>
                <gender>Male</gender>
                <cellphone_number>0721234567</cellphone_number>
                <pgwc_practitioner_number>72254311</pgwc_practitioner_number>
                <sa_id_number/>
                <passport_number/>
            </result>
        </ns1:getPractitionerResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
"""

    @Test
    void shouldBuildIdartPractitioner() throws Exception {

        def envelope = new XmlSlurper().parseText(xml)
        def practitioner = PractitionerBuilder.buildPractitioner(envelope)

        Assert.assertEquals("AEIGHT", practitioner.person.firstName)
        Assert.assertEquals("TEST", practitioner.person.lastName)
        Assert.assertEquals("72254311", practitioner.getIdValue("http://prehmis.capetown.gov.za"))

        practitioner.person.contactMechanisms.each { contactMechanism ->
            if (contactMechanism.contactMechanism instanceof MobileTelephoneNumber) {
                Assert.assertEquals("27", ((MobileTelephoneNumber) contactMechanism.contactMechanism).countryCode)
                Assert.assertEquals("0721234567", ((MobileTelephoneNumber) contactMechanism.contactMechanism).contactNumber)
            }
        }
    }
}
