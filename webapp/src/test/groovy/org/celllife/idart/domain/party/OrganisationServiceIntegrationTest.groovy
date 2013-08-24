package org.celllife.idart.domain.party

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.organisation.LegalOrganisation
import org.celllife.idart.domain.organisation.OrganisationService
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
class OrganisationServiceIntegrationTest {

    @Autowired OrganisationService organisationService

    @Test
    void testName() throws Exception {

        def id = OrganisationId.valueOf("LEGALORG-0000001")

        LegalOrganisation legalOrganisation = new LegalOrganisation(id: id)
        legalOrganisation.id = id
        legalOrganisation.name = "Test Org"
        legalOrganisation.taxRegistrationNumber = "10000000"

        organisationService.save(legalOrganisation)

        organisationService.findByOrganisationId(id)
    }
}
