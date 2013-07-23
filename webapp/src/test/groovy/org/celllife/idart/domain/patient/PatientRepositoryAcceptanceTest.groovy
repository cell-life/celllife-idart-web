package org.celllife.idart.domain.patient

import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.person.PersonResource
import org.celllife.idart.interfaces.service.patient.PatientServiceClient
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h51
 */
class PatientRepositoryAcceptanceTest {

    @Before
    void setUp() throws Exception {

        PatientResource.clear()
        PersonResource.clear()

        PersonResource.post(PersonResource.testPerson())
        PatientServiceClient.post(PatientResource.testPatient())

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    void shouldFindPatientByIdentifierValue() throws Exception {

        def patients = PatientResource.findByIdentifier("1234")

        assertNotNull patients
        assertEquals(1, patients.content.size)

    }
}
