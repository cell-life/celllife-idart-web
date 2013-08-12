package org.celllife.idart.domain.party

import org.celllife.idart.common.PartyIdentifier
import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.domain.legalorganisation.LegalOrganisationService
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 19h14
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class LegalOrganisationServiceIntegrationTest {

    @Autowired LegalOrganisationService legalOrganisationService

    @Test
    void testName() throws Exception {

        def identifier = PartyIdentifier.valueOf("LEGALORG-0000001")

        LegalOrganisation legalOrganisation = new LegalOrganisation(identifier: identifier)
        legalOrganisation.identifier = identifier
        legalOrganisation.name = "Test Org"
        legalOrganisation.taxRegistrationNumber = "10000000"

        legalOrganisationService.findByPartyIdentifier(identifier)
    }
}
