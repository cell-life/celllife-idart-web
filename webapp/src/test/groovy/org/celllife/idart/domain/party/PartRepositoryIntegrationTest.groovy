package org.celllife.idart.domain.party

import org.celllife.idart.application.medication.MedicationApplicationService
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.medication.Medication

import org.celllife.idart.domain.product.Product
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
 * Date: 2013-06-16
 * Time: 19h14
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PartRepositoryIntegrationTest {

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired MedicationApplicationService medicationApplicationService

    @Autowired PartApplicationService partApplicationService

    @Test
    void testName() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure(name: "Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")
        milligrams = unitOfMeasureService.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure(name: "Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        millilitres = unitOfMeasureService.save(millilitres)

        UnitOfMeasure each = new UnitOfMeasure(name: "Each")
        each.addCode("http://unitsofmeasure.org", "ea")
        each = unitOfMeasureService.save(each)

        Compound abacavirCompound = new Compound(unitOfMeasure: milligrams)
        abacavirCompound.addId("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirCompound = partApplicationService.save(abacavirCompound)

        Drug abacavir20mg = new Drug(unitOfMeasure: millilitres)
        abacavir20mg.addId("http://www.cell-life.org/idart/drugs", "Abacavir 20mg/ml")
        abacavir20mg.addEngineeringPart(abacavirCompound, 20.0D, milligrams)
        abacavir20mg = partApplicationService.save(abacavir20mg)

        Drug drug = new Drug(unitOfMeasure: each)
        drug.addId("http://www.cell-life.org/idart/drugs", "Abacavir 20mg/ml 240ml")
        drug.addEngineeringPart(abacavir20mg, 240.0D, millilitres)
        drug = partApplicationService.save(drug)

        Medication good = new Medication(drug: drug)
        ((Product) good).addId("http://www.cell-life.org/idart/medications", "Abacavir 20mg/ml")
        medicationApplicationService.save(good)

    }
}
