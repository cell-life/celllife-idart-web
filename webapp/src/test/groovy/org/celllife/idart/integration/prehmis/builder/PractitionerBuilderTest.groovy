package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber
import org.junit.Assert
import org.junit.Test

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.integration.prehmis.builder.PractitionerBuilder.getPREHMIS_NAMESPACE
import static org.celllife.idart.integration.prehmis.builder.PractitionerBuilder.getSOAP_NAMESPACE

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 17h55
 */
class PractitionerBuilderTest {

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

    @Test
    void shouldBuildIdartPractitioner() throws Exception {

        def envelope = new XmlSlurper().parseText(xml)
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def result = envelope.'soap:Body'.'prehmis:getPractitionerListResponse'.result.item[0]
        def practitioner = PractitionerBuilder.buildPractitioner(result)

        Assert.assertEquals("Berenice", practitioner.person.firstName)
        Assert.assertEquals("Carolus", practitioner.person.lastName)
        Assert.assertEquals("1159", getIdentifierValue(practitioner.identifiers, PREHMIS.id))
    }
}
