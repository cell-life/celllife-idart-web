package org.celllife.idart.integration.prehmis.builder

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.PREHMIS

import org.junit.Assert
import org.junit.Before;
import org.junit.Test


class PractitionerBuilderTest {

    PractitionerBuilder practitionerBuilder = new PrehmisPractitionerBuilder()

    String xml =
    """<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
               xmlns:prehmis="http://prehmis-qa.capetown.gov.za/"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soap:Header>
        <prehmis:AuthHeaderElement xsi:type="prehmis:AuthHeader">
            <username></username>
            <password></password>
            <facility_code></facility_code>
            <application_key></application_key>
        </prehmis:AuthHeaderElement>
    </soap:Header>
    <soap:Body>
        <prehmis:getPractitionerListResponse>
            <result>
                <item>
                    <id>1086</id>
                    <practitioner_type>Enrolled Nurse</practitioner_type>
                    <first_name>Berenice</first_name>
                    <last_name>Carolus</last_name>
                    <practitioner_code>1159</practitioner_code>
                </item>
            </result>
        </prehmis:getPractitionerListResponse>
    </soap:Body>
</soap:Envelope>
"""

    @Before
    void setup() throws Exception {
        ((PrehmisPractitionerBuilder)practitionerBuilder).prehmisNamespace = "http://prehmis-qa.capetown.gov.za/"
    }

    @Test
    void shouldBuildIdartPractitioner() throws Exception {

        def envelope = new XmlSlurper().parseText(xml)
        def soapNamespace = 'http://schemas.xmlsoap.org/soap/envelope/'
        def prehmisNamespace = 'http://prehmis-qa.capetown.gov.za/'
        envelope.declareNamespace(soap: soapNamespace, prehmis: prehmisNamespace)

        def result = envelope.'soap:Body'.'prehmis:getPractitionerListResponse'.result.item[0]
        def practitioner = practitionerBuilder.buildPractitioner(result)

        Assert.assertEquals("Berenice", practitioner.person.firstName)
        Assert.assertEquals("Carolus", practitioner.person.lastName)
        Assert.assertEquals("1159", getIdentifierValue(practitioner.identifiers, PREHMIS.id))
    }
}
