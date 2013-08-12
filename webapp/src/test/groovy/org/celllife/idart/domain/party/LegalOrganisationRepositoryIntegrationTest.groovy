package org.celllife.idart.domain.party

import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.domain.legalorganisation.LegalOrganisationRepository
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
class LegalOrganisationRepositoryIntegrationTest {

    @Autowired LegalOrganisationRepository legalOrganisationRepository

    @Test
    void testName() throws Exception {

        LegalOrganisation legalOrganisation = new LegalOrganisation()
        legalOrganisation.setName("Test Org")
        legalOrganisation.setTaxRegistrationNumber("10000000")

        legalOrganisation = legalOrganisationRepository.save(legalOrganisation)

        legalOrganisationRepository.findOne(legalOrganisation.pk)
    }
}
