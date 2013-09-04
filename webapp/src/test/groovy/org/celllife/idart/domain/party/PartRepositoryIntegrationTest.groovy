package org.celllife.idart.domain.party

import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.product.Medication

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.common.Label.label
import static org.celllife.idart.common.PartId.partId
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 19h14
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PartRepositoryIntegrationTest {

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired ProductApplicationService productApplicationService

    @Autowired PartApplicationService partApplicationService

    @Test
    void testName() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure(name: "Milligrams")
        milligrams.code = unitOfMeasureCode("mg")
        unitOfMeasureService.save(milligrams)

        UnitOfMeasure millilitres = new UnitOfMeasure(name: "Millilitres")
        millilitres.code = unitOfMeasureCode("ml")
        unitOfMeasureService.save(millilitres)

        UnitOfMeasure each = new UnitOfMeasure(name: "Each")
        each.code = unitOfMeasureCode("ea")
        unitOfMeasureService.save(each)

        Compound abacavirCompound = new Compound(unitOfMeasure: milligrams.code)
        abacavirCompound.id = partId("Abacavir")
        partApplicationService.save(abacavirCompound)

        Drug abacavir20mg = new Drug(unitOfMeasure: millilitres.code)
        abacavir20mg.id = partId("00001")
        abacavir20mg.label = label("Abacavir 20mg/ml")
        abacavir20mg.addEngineeringPart(abacavirCompound.id, 20.0D, milligrams.code)
        partApplicationService.save(abacavir20mg)

        Drug drug = new Drug(unitOfMeasure: each.code)
        drug.id = partId("00002")
        drug.label = label("Abacavir 20mg/ml 240ml")
        drug.addEngineeringPart(abacavir20mg.id, 240.0D, millilitres.code)
        partApplicationService.save(drug)

        Medication good = new Medication(drug: drug.id)
        good.name = "Abacavir 20mg/ml"
        productApplicationService.save(good)

    }
}
