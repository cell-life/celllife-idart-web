package org.celllife.idart.interfaces.service.practitioner

import org.celllife.idart.domain.assignment.AssignmentResource
import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.patient.PatientResource
import org.celllife.idart.domain.person.PersonResource
import org.celllife.idart.domain.practitioner.PractitionerResource
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h51
 */
class PractitionerServiceAcceptanceTest {

    @Before
    void setUp() throws Exception {

        AssignmentResource.clear()

        PatientResource.clear()
        PractitionerResource.clear()
        PersonResource.clear()

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    void shouldFindPractitionerByClinicIdentifier() throws Exception {
        assertPractitionersExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
    }

    @Test
    void shouldFindPractitionerByClinicIdentifierTwice() throws Exception {
        assertPractitionersExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
        assertPractitionersExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic")
    }

    static assertPractitionersExists(String applicationId, String idartClinicIdentifier) {

        def practitioners = PractitionerService.findByClinicIdentifier(applicationId, idartClinicIdentifier)

        assertNotNull practitioners
        assertEquals(13, practitioners.size)
    }
}
