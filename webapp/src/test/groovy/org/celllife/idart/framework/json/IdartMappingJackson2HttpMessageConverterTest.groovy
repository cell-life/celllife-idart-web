package org.celllife.idart.framework.json

import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.FinishedGood
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

        def message = new MockHttpOutputMessage()

        converter.write(list, MediaType.APPLICATION_JSON, message)

        println message.bodyAsString

    }
}