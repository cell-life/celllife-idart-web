package org.celllife.idart.interfaces.service.doctor

import org.celllife.idart.domain.assignment.AssignmentResource
import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.doctor.DoctorResource
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h51
 */
class DoctorServiceAcceptanceTest {

    @Before
    void setUp() throws Exception {

        AssignmentResource.clear()

        DoctorResource.clear()

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    public void shouldFindDoctorByClinicIdentifier() throws Exception {
        assertDoctorsExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
    }

    @Test
    public void shouldFindDoctorByClinicIdentifierTwice() throws Exception {
        assertDoctorsExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
        assertDoctorsExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
    }

    static assertDoctorsExists(String applicationId, String idartClinicIdentifier) {

        def doctors = DoctorService.findByClinicIdentifier(applicationId, idartClinicIdentifier)

        assertNotNull doctors
        assertEquals(13, doctors.size)

    }
}
