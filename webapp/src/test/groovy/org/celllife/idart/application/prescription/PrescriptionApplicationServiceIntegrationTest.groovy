package org.celllife.idart.application.prescription

import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.PartBillOfMaterialsType.ENGINEERING
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartClassificationApplications.partClassificationApplications

import javax.inject.Inject

import org.celllife.idart.application.facility.FacilityApplicationService;
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.DrugDto
import org.celllife.idart.application.part.dto.PartBillOfMaterialsItemDto
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.application.product.dto.MedicationDto
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PartId
import org.celllife.idart.common.PractitionerType
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.UnitsOfMeasure
import org.celllife.idart.domain.counter.CounterRepository
import org.celllife.idart.domain.encounter.EncounterRepository
import org.celllife.idart.domain.identifiable.IdentifiableRepository
import org.celllife.idart.domain.part.PartRepository
import org.celllife.idart.domain.patient.PatientRepository
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.domain.practitioner.PractitionerRepository
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationRepository
import org.celllife.idart.domain.prescription.PrescriptionRepository
import org.celllife.idart.domain.product.ProductRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.data.repository.CrudRepository
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 20h00
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PrescriptionApplicationServiceIntegrationTest {

    @Inject ProductApplicationService productApplicationService

    @Inject ProductRepository productRepository

    @Inject PartApplicationService partApplicationService

    @Inject PartRepository partRepository

    @Inject PrescriptionApplicationService prescriptionApplicationService

    @Inject PrescriptionRepository prescriptionRepository

    @Inject PrescribedMedicationRepository prescribedMedicationRepository

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PractitionerRepository practitionerRepository

    @Inject PatientApplicationService patientApplicationService

    @Inject PatientRepository patientRepository

    @Inject EncounterRepository encounterRepository

    @Inject FacilityApplicationService facilityApplicationService

    @Inject PersonRepository personRepository

    @Inject IdentifiableRepository identifiableRepository

    @Inject CounterRepository counterRepository

    @Inject ObjectMapper objectMapper

    /*@Before
    public void setUp() throws Exception {

        [counterRepository, identifiableRepository, personRepository, patientRepository,
                practitionerRepository, encounterRepository, prescriptionRepository, prescribedMedicationRepository,
                productRepository, partRepository].each { repository ->
            ((CrudRepository) repository).deleteAll()
        }

    }*/

    @Test
    void shouldUnmarshal() throws Exception {

        // ***************************************** Create Compound ************************************************

        def compound = new CompoundDto()
        compound.with {
            label = label("Abacavir")
        }
        partApplicationService.save(compound)

        // ***************************************** Create Drug ****************************************************

        DrugDto drug = new DrugDto()
        drug.with {
            label = label("Abacavir 20mg/ml")
            quantity = Quantity.newQuantity(240.0, UnitsOfMeasure.mL.code)
            billOfMaterials = [newEngineeringPart(compound.identifiers, 20.0D, UnitsOfMeasure.mg.code)]
            classifications = partClassificationApplications("J05AF06", ATC)
        }
        partApplicationService.save(drug)

        // ***************************************** Create Medication **********************************************

        MedicationDto medication = new MedicationDto(drug: drug.identifiers)
        medication.with {

            identifiers = [
                    newIdentifier("Abacavir 20mg/ml 240ml")
            ]

            name = "Abacavir 20mg/ml 240ml"
        }
        productApplicationService.save(medication)

        // ***************************************** Create Patient *************************************************

        PatientDto patient = new PatientDto()
        patient.with {

            identifiers = [
                    newIdentifier(PGWC.id, "72254311")
            ]

            person = new PersonDto()
            person.with {
                firstName = "Peter"
                lastName = "Patient"
            }
        }
        patientApplicationService.save(patient)

        // ***************************************** Create Practitioner ********************************************

        PractitionerDto practitioner = new PractitionerDto()
        practitioner.with {

            identifiers = [
                    newIdentifier(PREHMIS.id, "715")
            ]

            type = PractitionerType.AGENCY_DOCTORS

            person = new PersonDto()
            person.with {

                identifiers = [
                        newIdentifier(SA_IDENTITY_NUMBER.id, "7501015434082")
                ]

                firstName = "Derek"
                lastName = "Doctor"
            }
        }
        practitionerApplicationService.save(practitioner)

        // ***************************************** Create Prescription ********************************************
        
        InputStream prescriptionInputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        PrescriptionDto prescription = objectMapper.readValue(prescriptionInputStream, PrescriptionDto.class)

        prescription.identifiers = newIdentifiers("${System.currentTimeMillis()}")
        
        PrescriptionId prescriptionId = prescriptionApplicationService.save(prescription)
		
		Thread.sleep(5000L)
		
		// ***************************************** Delete Prescription ********************************************

		prescriptionApplicationService.deleteByPrescriptionId(prescriptionId)

        Thread.sleep(10000L)
    }

    @Test
    void saveDrugOneBillOfParts() throws Exception {

        // ***************************************** Create Compound ************************************************

        def compound = new CompoundDto()
        compound.with {
            label = label("Abacavir")
        }
        partApplicationService.save(compound)

        // ***************************************** Create Drug ****************************************************

        DrugDto drug = new DrugDto()
        drug.with {
            label = label("Abacavir 20mg/ml")
            quantity = Quantity.newQuantity(240.0, UnitsOfMeasure.mL.code)
            billOfMaterials = [newEngineeringPart(compound.identifiers, 20.0D, UnitsOfMeasure.mg.code)]
            classifications = partClassificationApplications("J05AF06", ATC)
        }
        PartId partId1 = partApplicationService.save(drug)
        Assert.assertNotNull(partId1)
        PartId partId2 = partApplicationService.findByIdentifiers(drug.getIdentifiers())
        Assert.assertNotNull(partId2)
        Assert.assertTrue(partId1.equals(partId2))
        
        DrugDto drug1 = (DrugDto)partApplicationService.findByPartId(partId1);
        Assert.assertNotNull(drug1)
        Assert.assertNotNull(drug1.getBillOfMaterials())
        DrugDto drug2 = (DrugDto)partApplicationService.findByPartId(partId2);
        Assert.assertNotNull(drug2)
        Assert.assertNotNull(drug2.getBillOfMaterials())
        Assert.assertEquals(drug.getBillOfMaterials().size(), drug1.getBillOfMaterials().size())
        Assert.assertEquals(drug.getBillOfMaterials().size(), drug2.getBillOfMaterials().size())
        
/*
        DrugDto drug1 = (DrugDto)partApplicationService.findByPartId(partId2);
        Assert.assertNotNull(drug1)
        Assert.assertNotNull(drug1.getBillOfMaterials())
        Assert.assertEquals(drug.getBillOfMaterials().size(), drug1.getBillOfMaterials().size())
        */
    }

    static PartBillOfMaterialsItemDto newEngineeringPart(Set<Identifier> part, Double quantity, UnitOfMeasureCode unitOfMeasure) {
        new PartBillOfMaterialsItemDto(
                type: ENGINEERING,
                part: part,
                quantityUsed: new Quantity(
                        value: quantity,
                        unitOfMeasure: unitOfMeasure
                )
        )
    }
}
