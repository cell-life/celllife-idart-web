package org.celllife.idart.test

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.dispensation.DispensationApplicationService
import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.DrugDto
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.application.product.dto.MedicationDto
import org.celllife.idart.application.system.SystemApplicationService
import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.application.systemfacility.SystemFacilityApplicationService
import org.celllife.idart.application.systemfacility.dto.SystemFacilityDto
import org.celllife.idart.common.Systems
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.Identifiers.newIdentifiers

/**
 * User: Kevin W. Sewell
 * Date: 2013-10-09
 * Time: 19h15
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class SmokeTest {

    @Inject PatientApplicationService patientApplicationService

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PartApplicationService partApplicationService

    @Inject ProductApplicationService productApplicationService

    @Inject PrescriptionApplicationService prescriptionApplicationService

    @Inject DispensationApplicationService dispensationApplicationService

    @Inject FacilityApplicationService facilityApplicationService

    @Inject SystemApplicationService systemApplicationService

    @Inject SystemFacilityApplicationService systemFacilityApplicationService

    @Inject ObjectMapper objectMapper

    @Test
    public void smokeTest() throws Exception {

        // ********************************************************************************************************

        def systemInputStream = getClass().getResourceAsStream("/data/smoketest/system.json")
        def system = objectMapper.readValue(systemInputStream, SystemDto)

        def systemId = systemApplicationService.save(system)

        // ********************************************************************************************************

        def facilityInputStream = getClass().getResourceAsStream("/data/smoketest/facility.json")
        def facility = objectMapper.readValue(facilityInputStream, FacilityDto)

        def facilityId = facilityApplicationService.save(facility)

        // ********************************************************************************************************

        def systemFacilityInputStream = getClass().getResourceAsStream("/data/smoketest/systemfacility.json")
        def systemFacility = objectMapper.readValue(systemFacilityInputStream, SystemFacilityDto)

        def systemFacilityId = systemFacilityApplicationService.save(systemFacility)

        // ********************************************************************************************************

        def patients = patientApplicationService.findByIdentifierAndSystem("72254311", systemId)

        // ********************************************************************************************************

        def practitioners = practitionerApplicationService.findBySystem(systemId)

        // ********************************************************************************************************

        def compoundInputStream = getClass().getResourceAsStream("/data/smoketest/compound.json")
        def compound = objectMapper.readValue(compoundInputStream, CompoundDto)

        def compoundId = partApplicationService.save(compound)

        def compoundDto = partApplicationService.findByPartId(compoundId)

        Assert.assertNotNull(compoundDto)

        // ********************************************************************************************************

        def drugInputStream = getClass().getResourceAsStream("/data/smoketest/drug.json")
        def drug = objectMapper.readValue(drugInputStream, DrugDto)

        def drugId = partApplicationService.save(drug)

        def drugDto = partApplicationService.findByPartId(drugId)

        Assert.assertNotNull(drugDto)

        // ********************************************************************************************************

        def medicationInputStream = getClass().getResourceAsStream("/data/smoketest/medication.json")
        def medication = objectMapper.readValue(medicationInputStream, MedicationDto)

        def medicationId = productApplicationService.save(medication)

        def medicationDto = productApplicationService.findByProductId(medicationId)

        Assert.assertNotNull(medicationDto)

        // ********************************************************************************************************

        def prescriptionInputStream = getClass().getResourceAsStream("/data/smoketest/prescription.json")
        def prescription = objectMapper.readValue(prescriptionInputStream, PrescriptionDto)
        prescription.identifiers = newIdentifiers(Systems.IDART_WEB.id, "${System.currentTimeMillis()}")

        def prescriptionId = prescriptionApplicationService.save(systemId, prescription)

        def prescriptionDto = prescriptionApplicationService.findByPrescriptionId(prescriptionId)

        Assert.assertNotNull(prescriptionDto)

        // ********************************************************************************************************

        def dispensationInputStream = getClass().getResourceAsStream("/data/smoketest/dispensation.json")
        def dispensation = objectMapper.readValue(dispensationInputStream, DispensationDto)
        dispensation.identifiers = newIdentifiers(Systems.IDART_WEB.id, "${System.currentTimeMillis()}")

        def dispensationId = dispensationApplicationService.save(systemId, dispensation)

        def dispensationDto = dispensationApplicationService.findByDispensationId(dispensationId)

        Assert.assertNotNull(dispensationDto)

        // ********************************************************************************************************

    }
}
