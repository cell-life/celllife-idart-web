package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.compound.CompoundResourceService
import org.celllife.idart.application.drug.DrugResourceService
import org.celllife.idart.application.medication.MedicationResourceService
import org.celllife.idart.application.patient.PatientResourceService
import org.celllife.idart.application.practitioner.PractitionerResourceService
import org.celllife.idart.application.unitofmeasure.UnitOfMeasureResourceService
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

    @Autowired MedicationResourceService medicationResourceService

    @Autowired DrugResourceService drugResourceService

    @Autowired CompoundResourceService compoundResourceService

    @Autowired PrescriptionResourceService prescriptionResourceService

    @Autowired PractitionerResourceService practitionerResourceService

    @Autowired PatientResourceService patientResourceService

    @Autowired UnitOfMeasureResourceService unitOfMeasureResourceService

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldUnmarshal() throws Exception {

        UnitOfMeasure milligrams = createMilligrams()
        unitOfMeasureResourceService.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure()
        millilitres.setName("Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        unitOfMeasureResourceService.save(millilitres)

        unitOfMeasureResourceService.save(createEach())

        compoundResourceService.save(createCompound(milligrams))

        drugResourceService.save(createDrug(millilitres, createCompound(milligrams), milligrams))

        drugResourceService.save(createFinishedDrug(createEach(), createDrug(millilitres, createCompound(milligrams), milligrams), millilitres))

        Medication medication = new Medication(drug: createFinishedDrug(createEach(), createDrug(millilitres, createCompound(milligrams), milligrams), millilitres))
        medication.addIdentifier("http://www.cell-life.org/idart/medications", "Abacavir 20mg/ml 240ml")
        medicationResourceService.save(medication)

        Patient patient = new Patient()
        patient.addIdentifier("http://www.cell-life.org/idart/patients", "00001")
        patient.person = new Person()
        patientResourceService.save(patient)

        Practitioner practitioner = new Practitioner()
        practitioner.addIdentifier("http://www.cell-life.org/idart/practitioners", "00001")
        practitioner.person = new Person()
        practitionerResourceService.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        Prescription prescription = objectMapper.readValue(inputStream, Prescription.class)
        System.out.println(prescription)

        prescriptionResourceService.save(prescription)
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
        Compound abacavirRawMaterial = new Compound()
        abacavirRawMaterial.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirRawMaterial.setUnitOfMeasure(milligrams)
        abacavirRawMaterial
    }

    static Drug createDrug(UnitOfMeasure millilitres, Compound abacavirRawMaterial, UnitOfMeasure milligrams) {
        Drug abacavir20mg = new Drug()
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml")
        abacavir20mg.setUnitOfMeasure(millilitres)
        abacavir20mg.addEngineeringPart(abacavirRawMaterial, 20.0D, milligrams)
        abacavir20mg
    }

    static Drug createFinishedDrug(UnitOfMeasure each, Drug abacavir20mg, UnitOfMeasure millilitres) {
        Drug finishedGood = new Drug()
        finishedGood.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml 240ml")
        finishedGood.setUnitOfMeasure(each)
        finishedGood.addEngineeringPart(abacavir20mg, 240.0D, millilitres)
        finishedGood
    }
}
