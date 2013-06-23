package org.celllife.idart.integration.prehmis;

import org.celllife.idart.application.patient.PatientProvider;
import org.celllife.idart.domain.patient.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 16h00
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-integration-prehmis.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class PrehmisPatientServiceIntegrationTest {

    @Autowired
    private PatientProvider patientProvider;

    @Test
    public void testFindByIdentifier() throws Exception {

        Set<Patient> patients = patientProvider.findByIdentifier("WES", "72254311");
        Assert.assertNotNull(patients);
        Assert.assertFalse(patients.isEmpty());
    }
}
