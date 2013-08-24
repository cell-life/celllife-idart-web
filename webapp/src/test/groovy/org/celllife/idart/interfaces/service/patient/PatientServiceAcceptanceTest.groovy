package org.celllife.idart.interfaces.service.patient


import org.celllife.idart.domain.clinic.ClinicResource
import org.celllife.idart.domain.patient.PatientResource
import org.celllife.idart.domain.person.PersonResource
import org.celllife.idart.domain.practitioner.PractitionerResource
import org.junit.Before
import org.junit.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
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
        PractitionerResource.clear()
        PersonResource.clear()

        ClinicResource.clear()
        ClinicResource.post(ClinicResource.testClinic())
    }

    @Test
    void shouldFindPatientByIdValue() throws Exception {
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "17768102")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254212")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "1")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "2")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "3")
    }

    @Test
    void shouldFindPatientByIdValueTwice() throws Exception {
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
        assertPatientExists("2AEFB796-8501-45C3-A0CE-3818088D338D", "Green Point Clinic", "72254311")
    }

    static assertPatientExists(String applicationId, String idartClinicId, String patientId) {

        def patients = PatientServiceClient.findById(applicationId, idartClinicId, patientId)

        println "***************************************************************************************************"
        println "***************************************************************************************************"
        println prettyPrint(toJson(patients))
        println "***************************************************************************************************"
        println "***************************************************************************************************"

        assertNotNull patients
        assertEquals(1, patients.size)
    }
}
