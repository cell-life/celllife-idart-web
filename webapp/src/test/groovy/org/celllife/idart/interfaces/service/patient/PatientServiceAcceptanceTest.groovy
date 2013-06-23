package org.celllife.idart.interfaces.service.patient

import org.celllife.idart.domain.assignment.AssignmentResource
import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.doctor.DoctorResource
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
//        PatientResource.post(PatientResource.testPatient())

        AssignmentResource.clear()

        DoctorResource.clear()

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    public void shouldFindPatientByIdentifierValue() throws Exception {
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
    }

    @Test
    public void shouldFindPatientByIdentifierValueTwice() throws Exception {
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
    }

    static assertPatientExists(String applicationId, String idartClinicIdentifier, String patientIdentifier) {

        def response = PatientService.findByIdentifier(applicationId, idartClinicIdentifier, patientIdentifier)

        assertNotNull response
        assertNotNull response.patients
        assertEquals(1, response.patients.size)
    }
}
