package org.celllife.idart.framework.json

import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.junit.Before
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.mock.http.MockHttpOutputMessage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 09h53
 */
class IdartMappingJackson2HttpMessageConverterTest {

    private IdartMappingJackson2HttpMessageConverter converter

    @Before
    public void setUp() throws Exception {

        converter = new IdartMappingJackson2HttpMessageConverter()
        converter.objectMapper = new IdartObjectMapper()
        converter.prefixJson = false

    }

    @Test
    public void testName() throws Exception {


        def unitOfMeasure = new UnitOfMeasure()
        unitOfMeasure.addName("en", "Bla")

        def compound = new Compound()
        compound.addId("bla1", "bla")
        compound.addId("bla", "bla")
        compound.unitOfMeasure = unitOfMeasure

        def drug = new Drug()
        drug.addId("bla1", "bla")
        drug.addId("bla", "bla")
        drug.unitOfMeasure = unitOfMeasure
        drug.addEngineeringPart(compound, 10.0D, unitOfMeasure)

        List<Drug> list = [] as ArrayList<Drug>
        list << drug

        def message = new MockHttpOutputMessage()

        converter.write(list, MediaType.APPLICATION_JSON, message)

        println message.bodyAsString

    }
}
