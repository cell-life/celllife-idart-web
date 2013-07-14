package org.celllife.idart.domain.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodRepository
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialRepository
import org.celllife.idart.domain.partyrole.PartyRole
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientRepository
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerRepository
import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.product.GoodRepository
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureRepository
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
class PrescriptionRepositoryIntegrationTest {

    @Autowired GoodRepository goodRepository

    @Autowired FinishedGoodRepository finishedGoodRepository

    @Autowired RawMaterialRepository rawMaterialRepository

    @Autowired PrescriptionRepository prescriptionRepository

    @Autowired PractitionerRepository practitionerRepository

    @Autowired PatientRepository patientRepository

    @Autowired UnitOfMeasureRepository unitOfMeasureRespository

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldUnmarshal() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure()
        milligrams.setName("Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")
        unitOfMeasureRespository.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure()
        millilitres.setName("Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        unitOfMeasureRespository.save(millilitres)

        UnitOfMeasure each = new UnitOfMeasure()
        each.setName("Each")
        each.addCode("http://unitsofmeasure.org", "ea")
        unitOfMeasureRespository.save(each)

        RawMaterial abacavirRawMaterial = new RawMaterial(name: "Abacavir")
        abacavirRawMaterial.setUnitOfMeasure(milligrams)
        rawMaterialRepository.save(abacavirRawMaterial)

        FinishedGood abacavir20mg = new FinishedGood(name: "Abacavir 20mg/ml")
        abacavir20mg.setUnitOfMeasure(millilitres)
        abacavir20mg.addEngineeringPart(new Date(), abacavirRawMaterial, 20.0D, milligrams)
        finishedGoodRepository.save(abacavir20mg)

        FinishedGood finishedGood = new FinishedGood(name: "Abacavir 20mg/ml 240ml")
        finishedGood.setUnitOfMeasure(each)
        finishedGood.addEngineeringPart(new Date(), abacavir20mg, 240.0D, millilitres)
        finishedGoodRepository.save(finishedGood)

        Good good = new Good(name: "Abacavir 20mg/ml", finishedGood: abacavir20mg)
        good.addCode("http://www.cell-life.org/idart/medication", "00001")
        goodRepository.save(good)

        Patient patient = new Patient()
        ((PartyRole) patient).addIdentifier("http://www.cell-life.org/idart/patient", "00001")
        patientRepository.save(patient)

        Practitioner practitioner = new Practitioner()
        ((PartyRole) practitioner).addIdentifier("http://www.cell-life.org/idart/practitioner", "00001")
        practitionerRepository.save(practitioner)

        InputStream inputStream = getClass().getResourceAsStream("/data/prescription/0000.json")
        Prescription prescription = objectMapper.readValue(inputStream, Prescription.class)
        System.out.println(prescription)

        prescriptionRepository.save(prescription)
    }
}
