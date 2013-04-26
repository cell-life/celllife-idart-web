package org.celllife.idart.domain.patient

import org.celllife.idart.domain.clinic.ClinicResource
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h51
 */
class PatientRepositoryAcceptanceTest {

    @Before
    void setUp() throws Exception {

        PatientResource.clear()
        PatientResource.post(PatientResource.testPatient())

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    public void shouldFindPatientByIdentifierValue() throws Exception {

        def patients = PatientResource.findByIdentifier("1234")

        assertNotNull patients
        assertEquals(1, patients.content.size)

        println patients
    }
}
