package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.application.unitofmeasure.UnitOfMeasureApplicationService
import org.celllife.idart.common.PartId
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.common.ProductId.productId
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode

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

        UnitOfMeasure milligrams = createMilligrams()
        unitOfMeasureApplicationService.save(milligrams)

        UnitOfMeasure millilitres = createMillilitres()
        unitOfMeasureApplicationService.save(millilitres)

        def each = createEach()
        unitOfMeasureApplicationService.save(each)

        def compound = createCompound(milligrams.code)
        partApplicationService.save(compound)

        def drug = createDrug(millilitres.code, compound.id, milligrams.code)
        partApplicationService.save(drug)

        def finishedDrug = createFinishedDrug(each.code, drug.id, millilitres.code)
        partApplicationService.save(finishedDrug)

        Medication medication = new Medication(drug: drug.id)
        medication.id = productId("00001")
        medication.name = "Abacavir 20mg/ml 240ml"
        productApplicationService.save(medication)

        PatientDto patient = new PatientDto()
        patient.person = new PersonDto()
        patientApplicationService.save(patient)

        Practitioner practitioner = new Practitioner()
        practitioner.id = practitionerId("00001")
        practitioner.person = personId("00001")
        practitionerApplicationService.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        Prescription prescription = objectMapper.readValue(inputStream, Prescription.class)
        System.out.println(prescription)

        prescriptionApplicationService.save(prescription)
    }

    static UnitOfMeasure createMillilitres() {
        UnitOfMeasure millilitres = new UnitOfMeasure()
        millilitres.name = "Millilitres"
        millilitres.code = unitOfMeasureCode("ml")
        millilitres
    }

    static UnitOfMeasure createMilligrams() {
        UnitOfMeasure milligrams = new UnitOfMeasure()
        milligrams.name = "Milligrams"
        milligrams.code = unitOfMeasureCode("mg")
        milligrams
    }

    static UnitOfMeasure createEach() {
        UnitOfMeasure each = new UnitOfMeasure()
        each.code = unitOfMeasureCode("ea")
        each.name = "Each"
        each
    }

    static Compound createCompound(UnitOfMeasureCode milligrams) {
        Compound abacavirCompound = new Compound()
        abacavirCompound.label = label("Abacavir")
        abacavirCompound.unitOfMeasure = milligrams
        abacavirCompound
    }

    static Drug createDrug(UnitOfMeasureCode millilitres, PartId abacavirCompound, UnitOfMeasureCode milligrams) {
        Drug abacavir20mg = new Drug()
        abacavir20mg.label = label("Abacavir 20mg/ml")
        abacavir20mg.unitOfMeasure = millilitres
        abacavir20mg.addEngineeringPart(abacavirCompound, 20.0D, milligrams)
        abacavir20mg
    }

    static Drug createFinishedDrug(UnitOfMeasureCode each, PartId abacavir20mg, UnitOfMeasureCode millilitres) {
        Drug drug = new Drug()
        drug.label = label("Abacavir 20mg/ml 240ml")
        drug.unitOfMeasure = each
        drug.addEngineeringPart(abacavir20mg, 240.0D, millilitres)
        drug
    }
}
