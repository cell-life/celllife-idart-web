package org.celllife.idart.integration.prehmis

import org.celllife.idart.application.practitioner.PractitionerProvider
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 16h00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
class PrehmisPractitionerProviderIntegrationTest {

    @Autowired PractitionerProvider practitionerProvider

    @Test
    void testFindById() throws Exception {

        Set<Practitioner> practitioners = practitionerProvider.findAll("WES")
        Assert.assertNotNull(practitioners)
        Assert.assertFalse(practitioners.empty)
    }
}
