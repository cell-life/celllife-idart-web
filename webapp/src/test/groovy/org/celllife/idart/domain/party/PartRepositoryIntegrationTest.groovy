package org.celllife.idart.domain.party

import org.celllife.idart.application.compound.CompoundResourceService
import org.celllife.idart.application.drug.DrugResourceService
import org.celllife.idart.application.medication.MedicationResourceService
import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialService
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

    @Autowired MedicationResourceService medicationResourceService

    @Autowired DrugResourceService drugResourceService

    @Autowired CompoundResourceService compoundResourceService

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

        Compound abacavirRawMaterial = new Compound(unitOfMeasure: milligrams)
        abacavirRawMaterial.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirRawMaterial = compoundResourceService.save(abacavirRawMaterial)

        Drug abacavir20mg = new Drug(unitOfMeasure: millilitres)
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml")
        abacavir20mg.addEngineeringPart(abacavirRawMaterial, 20.0D, milligrams)
        abacavir20mg = drugResourceService.save(abacavir20mg)

        Drug finishedGood = new Drug(unitOfMeasure: each)
        finishedGood.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml 240ml")
        finishedGood.addEngineeringPart(abacavir20mg, 240.0D, millilitres)
        finishedGood = drugResourceService.save(finishedGood)

        Medication good = new Medication(drug: finishedGood)
        ((Product) good).addIdentifier("http://www.cell-life.org/idart/medications", "Abacavir 20mg/ml")
        medicationResourceService.save(good)

    }
}
