package org.celllife.idart.application.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialService
import org.celllife.idart.domain.partyrole.PartyRole
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.product.GoodService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
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

    @Autowired GoodService goodService

    @Autowired FinishedGoodService finishedGoodService

    @Autowired RawMaterialService rawMaterialService

    @Autowired PrescriptionApplicationService prescriptionApplicationService

    @Autowired PractitionerService practitionerService

    @Autowired PatientService patientService

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldUnmarshal() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure()
        milligrams.setName("Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")
        unitOfMeasureService.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure()
        millilitres.setName("Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        unitOfMeasureService.save(millilitres)

        UnitOfMeasure each = new UnitOfMeasure()
        each.setName("Each")
        each.addCode("http://unitsofmeasure.org", "ea")
        unitOfMeasureService.save(each)

        RawMaterial abacavirRawMaterial = new RawMaterial()
        abacavirRawMaterial.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirRawMaterial.setUnitOfMeasure(milligrams)
        abacavirRawMaterial = rawMaterialService.save(abacavirRawMaterial)

        FinishedGood abacavir20mg = new FinishedGood()
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/finishedGood", "Abacavir 20mg/ml")
        abacavir20mg.setUnitOfMeasure(millilitres)
        abacavir20mg.addEngineeringPart(new Date(), abacavirRawMaterial, 20.0D, milligrams)
        abacavir20mg = finishedGoodService.save(abacavir20mg)

        FinishedGood finishedGood = new FinishedGood()
        finishedGood.addIdentifier("http://www.cell-life.org/idart/finishedGood", "Abacavir 20mg/ml 240ml")
        finishedGood.setUnitOfMeasure(each)
        finishedGood.addEngineeringPart(new Date(), abacavir20mg, 240.0D, millilitres)
        finishedGood = finishedGoodService.save(finishedGood)

        Good good = new Good(finishedGood: finishedGood)
        good.addIdentifier("http://www.cell-life.org/idart/good", "Abacavir 20mg/ml 240ml")
        goodService.save(good)

        Patient patient = new Patient()
        ((PartyRole) patient).addIdentifier("http://www.cell-life.org/idart/patient", "00001")
        patientService.save(patient)

        Practitioner practitioner = new Practitioner()
        ((PartyRole) practitioner).addIdentifier("http://www.cell-life.org/idart/practitioner", "00001")
        practitionerService.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        Prescription prescription = objectMapper.readValue(inputStream, Prescription.class)
        System.out.println(prescription)

        prescriptionApplicationService.save(prescription)
    }
}
