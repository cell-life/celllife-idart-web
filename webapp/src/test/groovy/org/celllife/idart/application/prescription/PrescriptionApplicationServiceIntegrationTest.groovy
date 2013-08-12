package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.compound.CompoundApplicationService
import org.celllife.idart.application.drug.DrugApplicationService
import org.celllife.idart.application.medication.MedicationApplicationService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.unitofmeasure.UnitOfMeasureApplicationService
import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 20h00
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PrescriptionApplicationServiceIntegrationTest {

    @Autowired MedicationApplicationService medicationApplicationService

    @Autowired DrugApplicationService drugApplicationService

    @Autowired CompoundApplicationService compoundApplicationService

    @Autowired PrescriptionApplicationService prescriptionApplicationService

    @Autowired PractitionerApplicationService practitionerApplicationService

    @Autowired PatientApplicationService patientApplicationService

    @Autowired UnitOfMeasureApplicationService unitOfMeasureApplicationService

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldUnmarshal() throws Exception {

        UnitOfMeasure milligrams = createMilligrams()
        unitOfMeasureApplicationService.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure()
        millilitres.setName("Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        unitOfMeasureApplicationService.save(millilitres)

        unitOfMeasureApplicationService.save(createEach())

        compoundApplicationService.save(createCompound(milligrams))

        drugApplicationService.save(createDrug(millilitres, createCompound(milligrams), milligrams))

        drugApplicationService.save(createFinishedDrug(createEach(), createDrug(millilitres, createCompound(milligrams), milligrams), millilitres))

        Medication medication = new Medication(drug: createFinishedDrug(createEach(), createDrug(millilitres, createCompound(milligrams), milligrams), millilitres))
        medication.addIdentifier("http://www.cell-life.org/idart/medications", "Abacavir 20mg/ml 240ml")
        medicationApplicationService.save(medication)

        Patient patient = new Patient()
        patient.addIdentifier("http://www.cell-life.org/idart/patients", "00001")
        patient.person = new Person()
        patientApplicationService.save(patient)

        Practitioner practitioner = new Practitioner()
        practitioner.addIdentifier("http://www.cell-life.org/idart/practitioners", "00001")
        practitioner.person = new Person()
        practitionerApplicationService.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        Prescription prescription = objectMapper.readValue(inputStream, Prescription.class)
        System.out.println(prescription)

        prescriptionApplicationService.save(prescription)
    }

    static UnitOfMeasure createMilligrams() {
        UnitOfMeasure milligrams = new UnitOfMeasure()
        milligrams.setName("Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")
        milligrams
    }

    static UnitOfMeasure createEach() {
        UnitOfMeasure each = new UnitOfMeasure()
        each.setName("Each")
        each.addCode("http://unitsofmeasure.org", "ea")
        each
    }

    static Compound createCompound(UnitOfMeasure milligrams) {
        Compound abacavirCompound = new Compound()
        abacavirCompound.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirCompound.setUnitOfMeasure(milligrams)
        abacavirCompound
    }

    static Drug createDrug(UnitOfMeasure millilitres, Compound abacavirCompound, UnitOfMeasure milligrams) {
        Drug abacavir20mg = new Drug()
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/drugs", "Abacavir 20mg/ml")
        abacavir20mg.setUnitOfMeasure(millilitres)
        abacavir20mg.addEngineeringPart(abacavirCompound, 20.0D, milligrams)
        abacavir20mg
    }

    static Drug createFinishedDrug(UnitOfMeasure each, Drug abacavir20mg, UnitOfMeasure millilitres) {
        Drug drug = new Drug()
        drug.addIdentifier("http://www.cell-life.org/idart/drugs", "Abacavir 20mg/ml 240ml")
        drug.setUnitOfMeasure(each)
        drug.addEngineeringPart(abacavir20mg, 240.0D, millilitres)
        drug
    }
}
