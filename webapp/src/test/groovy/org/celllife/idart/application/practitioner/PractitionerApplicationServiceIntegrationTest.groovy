package org.celllife.idart.application.practitioner

import org.celllife.idart.test.TestConfiguration
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 21h15
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PractitionerApplicationServiceIntegrationTest {

    @Autowired PractitionerApplicationService practitionerApplicationService

    @Test
    @Ignore
    public void shouldFindByClinicIdentifier() throws Exception {

        practitionerApplicationService.findByClinicIdentifier()

    }
}
