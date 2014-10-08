package org.celllife.idart.domain.contactmechanism

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.party.PartyContactMechanism
import org.celllife.idart.infrastructure.jackson.contactmechanism.ContactMechanismMixin
import org.junit.Before
import org.junit.Test


class TelecommunicationsNumberTest {

    private ObjectMapper objectMapper

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper()
        objectMapper.addMixInAnnotations(ContactMechanism, ContactMechanismMixin)
    }

    @Test
    public void testName() throws Exception {

        def telecommunicationsNumber =
            new TelecommunicationsNumber(areaCode: "021", contactNumber: "1234567", countryCode: "27")

        def mechanism = new PartyContactMechanism(contactMechanism: telecommunicationsNumber)

        println objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mechanism)

    }
}
