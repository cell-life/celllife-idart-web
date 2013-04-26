package org.celllife.idart.interfaces.service.patient

import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.patient.PatientResource
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h51
 */
class PatientServiceAcceptanceTest {

    @Before
    void setUp() throws Exception {

        PatientResource.clear()
        PatientResource.post(PatientResource.testPatient())

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    public void shouldFindPatientByIdentifierValue() throws Exception {

        def patients = PatientService.findByIdentifier("2AEFB796-8501-45C3-A0CE-3818088D338D", "Test Clinic", "72254311")

        assertNotNull patients
        assertEquals(1, patients.size)

        println patients
    }
}
