package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.encounter.EncounterApplicationService
import org.celllife.idart.application.encounter.dto.EncounterDto
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
import org.celllife.idart.common.PractitionerType
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
import org.celllife.idart.domain.prescription.PrescriptionRepository
import org.celllife.idart.domain.product.ProductRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.data.repository.CrudRepository
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Systems.*
import static org.celllife.idart.domain.part.PartBillOfMaterialsType.ENGINEERING
import static org.celllife.idart.domain.part.PartClassificationApplications.partClassificationApplications

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

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PractitionerRepository practitionerRepository

    @Inject PatientApplicationService patientApplicationService

    @Inject PatientRepository patientRepository

    @Inject EncounterApplicationService encounterApplicationService

    @Inject EncounterRepository encounterRepository

    @Inject PersonRepository personRepository

    @Inject IdentifiableRepository identifiableRepository

    @Inject CounterRepository counterRepository

    @Inject ObjectMapper objectMapper

    @Before
    public void setUp() throws Exception {

        [counterRepository, identifiableRepository, personRepository, patientRepository, practitionerRepository,
                encounterRepository, prescriptionRepository, productRepository, partRepository].each { repository ->
            ((CrudRepository) repository).deleteAll()
        }

    }

    @Test
    void shouldUnmarshal() throws Exception {

        def compound = new CompoundDto()
        compound.with {
            label = label("Abacavir")
            unitOfMeasure = UnitsOfMeasure.mg.code
        }
        partApplicationService.save(compound)

        DrugDto drug = new DrugDto()
        drug.with {
            label = label("Abacavir 20mg/ml")
            unitOfMeasure = UnitsOfMeasure.mL.code
            billOfMaterials = [newEngineeringPart(compound.identifiers, 20.0D, UnitsOfMeasure.mg.code)]
            classifications = partClassificationApplications("J05AF06", ATC)
        }
        partApplicationService.save(drug)

        DrugDto finishedDrug = new DrugDto()
        finishedDrug.with {
            label = label("Abacavir 20mg/ml 240ml")
            unitOfMeasure = UnitsOfMeasure.each.code
            billOfMaterials = [newEngineeringPart(drug.identifiers, 240.0D, UnitsOfMeasure.mL.code)]
            classifications = partClassificationApplications("J05AF06", ATC)
        }
        partApplicationService.save(finishedDrug)

        MedicationDto medication = new MedicationDto(drug: drug.identifiers)
        medication.with {

            identifiers = [
                    newIdentifier(IDART_WEB.id, "Abacavir 20mg/ml 240ml")
            ]

            name = "Abacavir 20mg/ml 240ml"
        }
        productApplicationService.save(medication)

        PatientDto patient = new PatientDto()
        patient.with {

            identifiers = [
                    newIdentifier(PGWC, "72254311")
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

        def encounter = new EncounterDto()
        encounter.with {

            identifiers = [
                    newIdentifier(IDART_WEB.id, "00001")
            ]

            facility = [
                    newIdentifier(PREHMIS.id, "WES")
            ]
        }
        encounterApplicationService.save(encounter)


        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        PrescriptionDto prescription = objectMapper.readValue(inputStream, PrescriptionDto.class)

        prescription.identifiers = [newIdentifier(IDART_WEB.id, "${System.currentTimeMillis()}")] as Set

        prescriptionApplicationService.save(prescription)

        Thread.sleep(10000L)
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
