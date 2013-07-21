package org.celllife.idart.domain.party

import org.celllife.idart.application.product.GoodApplicationService
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialService
import org.celllife.idart.domain.product.Good
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

    @Autowired GoodApplicationService goodApplicationService

    @Autowired FinishedGoodService finishedGoodService

    @Autowired RawMaterialService rawMaterialService

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

        RawMaterial abacavirRawMaterial = new Compound(unitOfMeasure: milligrams)
        abacavirRawMaterial.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        abacavirRawMaterial = rawMaterialService.save(abacavirRawMaterial)

        FinishedGood abacavir20mg = new Drug(unitOfMeasure: millilitres)
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml")
        abacavir20mg.addEngineeringPart(new Date(), abacavirRawMaterial, 20.0D, milligrams)
        abacavir20mg = finishedGoodService.save(abacavir20mg)

        FinishedGood finishedGood = new Drug(unitOfMeasure: each)
        finishedGood.addIdentifier("http://www.cell-life.org/idart/finishedGoods", "Abacavir 20mg/ml 240ml")
        finishedGood.addEngineeringPart(new Date(), abacavir20mg, 240.0D, millilitres)
        finishedGood = finishedGoodService.save(finishedGood)

        Good good = new Good(finishedGood: finishedGood)
        ((Product) good).addIdentifier("http://www.cell-life.org/idart/goods", "Abacavir 20mg/ml")
        goodApplicationService.save(good)

    }
}
