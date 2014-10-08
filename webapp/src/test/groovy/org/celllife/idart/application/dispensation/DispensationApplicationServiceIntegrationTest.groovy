package org.celllife.idart.application.dispensation

import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.PartBillOfMaterialsType.ENGINEERING
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartClassificationApplications.partClassificationApplications

import javax.inject.Inject

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.DrugDto
import org.celllife.idart.application.part.dto.PartBillOfMaterialsItemDto
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.application.product.dto.MedicationDto
import org.celllife.idart.common.*
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.fasterxml.jackson.databind.ObjectMapper


@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class DispensationApplicationServiceIntegrationTest {

    @Inject ProductApplicationService productApplicationService

    @Inject PartApplicationService partApplicationService

    @Inject PrescriptionApplicationService prescriptionApplicationService

    @Inject PrescribedMedicationRepository prescribedMedicationRepository

    @Inject DispensationApplicationService dispensationApplicationService

    @Inject FacilityApplicationService facilityApplicationService

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PatientApplicationService patientApplicationService

    @Inject ObjectMapper objectMapper

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
            label = label("Abacavir 20mg/ml 240ml")
            form = FormCode.valueOf("SYRUP")
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

        // ***************************************** Create Dispensation ********************************************

        InputStream dispensationInputStream = getClass().getResourceAsStream("/data/dispensation/0000.json")
        DispensationDto dispensation = objectMapper.readValue(dispensationInputStream, DispensationDto.class)

        dispensation.identifiers = newIdentifiers("${System.currentTimeMillis()}")

        DispensationId dispensationId = dispensationApplicationService.save(dispensation)

        Thread.sleep(5000L)
        
        // ***************************************** Delete Dispensation ********************************************

        dispensationApplicationService.deleteByDispensationId(dispensationId)

        Thread.sleep(5000L)

        // ***************************************** Delete Prescription ********************************************
        
        prescriptionApplicationService.deleteByPrescriptionId(prescriptionId)

        Thread.sleep(5000L)
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
