package org.celllife.idart.udm;

import org.celllife.idart.test.TestConfiguration;
import org.celllife.idart.udm.codedconcept.UnitOfMeasure;
import org.celllife.idart.udm.codedconcept.UnitOfMeasureRespository;
import org.celllife.idart.udm.part.*;
import org.celllife.idart.udm.product.Good;
import org.celllife.idart.udm.product.GoodRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 19h14
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PartRepositoryIntegrationTest {

    @Autowired
    private UnitOfMeasureRespository unitOfMeasureRespository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private FinishedGoodRepository finishedGoodRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Test
    public void testName() throws Exception {

        UnitOfMeasure milligrams = new UnitOfMeasure();
        milligrams.setName("Milligrams");
        milligrams.addCode("http://unitsofmeasure.org", "mg");
        unitOfMeasureRespository.save(milligrams);

        UnitOfMeasure millilitres = new UnitOfMeasure();
        millilitres.setName("Millilitres");
        millilitres.addCode("http://unitsofmeasure.org", "ml");
        unitOfMeasureRespository.save(millilitres);

        UnitOfMeasure each = new UnitOfMeasure();
        each.setName("Each");
        each.addCode("http://unitsofmeasure.org", "ea");
        unitOfMeasureRespository.save(each);

        RawMaterial abacavirRawMaterial = new RawMaterial("Abacavir");
        abacavirRawMaterial.setUnitOfMeasure(milligrams);
        rawMaterialRepository.save(abacavirRawMaterial);

        FinishedGood abacavir20mg = new FinishedGood("Abacavir 20mg/ml");
        abacavir20mg.setUnitOfMeasure(millilitres);
        abacavir20mg.addEngineeringPart(new Date(), abacavirRawMaterial, 20.0D, milligrams);
        finishedGoodRepository.save(abacavir20mg);

        FinishedGood finishedGood = new FinishedGood("Abacavir 20mg/ml 240ml");
        finishedGood.setUnitOfMeasure(each);
        finishedGood.addEngineeringPart(new Date(), abacavir20mg, 240.0D, millilitres);
        finishedGoodRepository.save(finishedGood);

        Good good = new Good("Abacavir 20mg/ml", abacavir20mg);
        goodRepository.save(good);

    }
}
