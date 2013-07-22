package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.type.TypeReference
import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.junit.Test

import java.lang.reflect.ParameterizedType

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-19
 * Time: 20h33
 */
class IdentifiableSerializerTest {

    @Test
    public void testName() throws Exception {

        List<FinishedGood> sd = new ArrayList<FinishedGood>()

        def type = (ParameterizedType) sd.class.genericSuperclass
        type.actualTypeArguments.each { actualTypeArgument ->
            println actualTypeArgument
        }
    }

    @Test
    public void shouldSerialize() throws Exception {

        def unitOfMeasure = new UnitOfMeasure()
        unitOfMeasure.addCode("s", "Bla")
        unitOfMeasure.addName("en", "Bla")

        def rawMaterial = new Compound()
        rawMaterial.addIdentifier("bla1", "bla")
        rawMaterial.addIdentifier("bla", "bla")
        rawMaterial.unitOfMeasure = unitOfMeasure

        def finishedGood = new Drug()
        finishedGood.addIdentifier("bla1", "bla")
        finishedGood.addIdentifier("bla", "bla")
        finishedGood.unitOfMeasure = unitOfMeasure
        finishedGood.addEngineeringPart(new Date(), rawMaterial, 10.0D, unitOfMeasure)

        List<FinishedGood> list = [] as ArrayList<FinishedGood>
        list << finishedGood

        println new IdartObjectMapper()
                .writerWithType(new TypeReference<List<FinishedGood>>() {})
                .withDefaultPrettyPrinter()
                .writeValueAsString(list)

    }
}
