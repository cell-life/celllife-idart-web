package org.celllife.idart.client.partyrole;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.celllife.idart.client.person.MobileTelephoneNumber;
import org.celllife.idart.client.person.PartyContactMechanism;
import org.celllife.idart.common.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h32
 */
public class PartyRoleSerializationTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldUnmarshalPatient() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/patients/0001.json");
        Patient partyRole = objectMapper.reader(Patient.class).readValue(inputStream);

        Assert.assertNotNull(partyRole);
        Assert.assertNotNull(partyRole.identifiers);
        Assert.assertTrue(partyRole.identifiers.size() != 0);
        Assert.assertNotNull(partyRole.person);
        Assert.assertTrue(partyRole.person.identifiers.size() != 0);
        Assert.assertEquals("AEIGHT", partyRole.person.firstName);
        Assert.assertEquals("TEST", partyRole.person.lastName);
        Assert.assertEquals(Gender.MALE, partyRole.person.gender);
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("1981-01-01"), partyRole.person.birthDate);

        for (PartyContactMechanism contactMechanism : partyRole.person.contactMechanisms) {
            if (contactMechanism.contactMechanism instanceof MobileTelephoneNumber) {
                Assert.assertEquals("27", ((MobileTelephoneNumber) contactMechanism.contactMechanism).countryCode);
                Assert.assertEquals("0723222064", ((MobileTelephoneNumber) contactMechanism.contactMechanism).contactNumber);
            }
        }
    }

    @Test
    public void shouldUnmarshalPractitioners() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/practitioners/0001.json");
        List<Practitioner> partyRoles = objectMapper.reader(new TypeReference<List<Practitioner>>() {
        }).readValue(inputStream);

        for (PartyRole partyRole : partyRoles) {
            Assert.assertNotNull(partyRole);
            Assert.assertNotNull(partyRole.identifiers);
            Assert.assertTrue(partyRole.identifiers.size() != 0);
            Assert.assertNotNull(partyRole.person);
            Assert.assertTrue(partyRole.person.identifiers.size() != 0);
        }
    }
}
