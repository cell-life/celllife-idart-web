package org.celllife.idart.udm

import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodRepository
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialRepository
import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.product.GoodRepository
import org.celllife.idart.domain.product.Product
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
 * Date: 2013-06-16
 * Time: 19h14
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PartRepositoryIntegrationTest {

    @Autowired UnitOfMeasureRepository unitOfMeasureRespository

    @Autowired GoodRepository goodRepository

    @Autowired FinishedGoodRepository finishedGoodRepository

    @Autowired RawMaterialRepository rawMaterialRepository

    @Test
    void testName() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure(name: "Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")
        unitOfMeasureRespository.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure(name: "Millilitres")
        millilitres.addCode("http://unitsofmeasure.org", "ml")
        unitOfMeasureRespository.save(millilitres)

        UnitOfMeasure each = new UnitOfMeasure(name: "Each")
        each.addCode("http://unitsofmeasure.org", "ea")
        unitOfMeasureRespository.save(each)

        RawMaterial abacavirRawMaterial = new RawMaterial(unitOfMeasure: milligrams)
        abacavirRawMaterial.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")
        rawMaterialRepository.save(abacavirRawMaterial)

        FinishedGood abacavir20mg = new FinishedGood(unitOfMeasure: millilitres)
        abacavir20mg.addIdentifier("http://www.cell-life.org/idart/finishedGood", "Abacavir 20mg/ml")
        abacavir20mg.addEngineeringPart(new Date(), abacavirRawMaterial, 20.0D, milligrams)
        finishedGoodRepository.save(abacavir20mg)

        FinishedGood finishedGood = new FinishedGood(unitOfMeasure: each)
        finishedGood.addIdentifier("http://www.cell-life.org/idart/finishedGood", "Abacavir 20mg/ml 240ml")
        finishedGood.addEngineeringPart(new Date(), abacavir20mg, 240.0D, millilitres)
        finishedGoodRepository.save(finishedGood)

        Good good = new Good(finishedGood: abacavir20mg)
        ((Product) good).name = "Abacavir 20mg/ml"
        goodRepository.save(good)

    }
}
