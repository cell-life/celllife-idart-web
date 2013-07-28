package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.type.TypeReference
import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug

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

        List<Drug> sd = new ArrayList<Drug>()

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

        def compound = new Compound()
        compound.addIdentifier("bla1", "bla")
        compound.addIdentifier("bla", "bla")
        compound.unitOfMeasure = unitOfMeasure

        def drug = new Drug()
        drug.addIdentifier("bla1", "bla")
        drug.addIdentifier("bla", "bla")
        drug.unitOfMeasure = unitOfMeasure
        drug.addEngineeringPart(compound, 10.0D, unitOfMeasure)

        List<Drug> list = [] as ArrayList<Drug>
        list << drug

        println new IdartObjectMapper()
                .writerWithType(new TypeReference<List<Drug>>() {})
                .withDefaultPrettyPrinter()
                .writeValueAsString(list)

    }
}
