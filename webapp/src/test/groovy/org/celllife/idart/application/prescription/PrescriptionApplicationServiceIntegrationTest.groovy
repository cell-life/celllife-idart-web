package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
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
import org.celllife.idart.application.unitofmeasure.UnitOfMeasureApplicationService
import org.celllife.idart.common.PractitionerType
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.SystemId.PREHMIS
import static org.celllife.idart.common.SystemId.SA_IDENTITY_NUMBER
import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.domain.part.PartBillOfMaterialsType.ENGINEERING

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 20h00
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PrescriptionApplicationServiceIntegrationTest {

    @Autowired ProductApplicationService productApplicationService

    @Autowired PartApplicationService partApplicationService

    @Autowired PrescriptionApplicationService prescriptionApplicationService

    @Autowired PractitionerApplicationService practitionerApplicationService

    @Autowired PatientApplicationService patientApplicationService

    @Autowired UnitOfMeasureApplicationService unitOfMeasureApplicationService

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldUnmarshal() throws Exception {

        def compound =  new CompoundDto()
        compound.with {
            label = label("Abacavir")
            unitOfMeasure = unitOfMeasureCode("mg")
        }
        partApplicationService.save(compound)

        DrugDto drug = new DrugDto()
        drug.with {
            label = label("Abacavir 20mg/ml")
            unitOfMeasure = unitOfMeasureCode("ml")
            billOfMaterials = [newEngineeringPart(compound.identifiers, 20.0D, unitOfMeasureCode("mg"))]
        }
        partApplicationService.save(drug)

        DrugDto finishedDrug = new DrugDto()
        finishedDrug.with {
            label = label("Abacavir 20mg/ml 240ml")
            unitOfMeasure = unitOfMeasureCode("each")
            billOfMaterials = [newEngineeringPart(drug.identifiers, 240.0D, unitOfMeasureCode("ml"))]
        }
        partApplicationService.save(finishedDrug)

        MedicationDto medication = new MedicationDto(drug: drug.identifiers)
        medication.with {

            identifiers = [
                    newIdentifier(IDART_WEB, "Abacavir 20mg/ml 240ml")
            ]

            name = "Abacavir 20mg/ml 240ml"
        }
        productApplicationService.save(medication)

        PatientDto patient = new PatientDto()
        patient.with {

            identifiers = [
                    newIdentifier(PREHMIS, "00000")
            ]

            person = new PersonDto()
            person.with {
                firstName = "Peter"
                lastName = "Patient"
            }
        }
        patientApplicationService.save(patient)

        PractitionerDto practitioner = new PractitionerDto()
        practitioner.with {

            identifiers = [
                    newIdentifier(PREHMIS, "00000")
            ]

            type = PractitionerType.AGENCY_DOCTORS

            person = new PersonDto()
            person.with {

                identifiers = [
                        newIdentifier(SA_IDENTITY_NUMBER, "7501015434082")
                ]

                firstName = "Derek"
                lastName = "Doctor"
            }
        }
        practitionerApplicationService.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        PrescriptionDto prescription = objectMapper.readValue(inputStream, PrescriptionDto.class)

        prescriptionApplicationService.save(prescription)
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
