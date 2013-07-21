package org.celllife.idart.integration.prehmis

import org.celllife.idart.application.patient.PatientProvider
import org.celllife.idart.domain.patient.Patient
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
@ContextConfiguration(
        [
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-integration-prehmis.xml"
        ]
)
@RunWith(SpringJUnit4ClassRunner.class)
class PrehmisPatientProviderIntegrationTest {

    @Autowired PatientProvider prehmisPatientProvider

    @Test
    void testFindByIdentifier() throws Exception {
        Set<Patient> patients = prehmisPatientProvider.findByIdentifier("WES", "72254311")
        Assert.assertNotNull(patients)
        Assert.assertFalse(patients.empty)
    }
}
