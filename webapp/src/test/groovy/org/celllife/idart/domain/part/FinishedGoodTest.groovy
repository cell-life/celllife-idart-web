package org.celllife.idart.domain.part

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.milyn.Smooks
import org.milyn.payload.JavaResult

import javax.xml.transform.stream.StreamSource

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h37
 */
class FinishedGoodTest {

    @Test
    public void shouldMarshalTestData() throws Exception {

        def inputStream = getClass().getResourceAsStream("/data/finishedGood/001.json")

        def finishedGood = new ObjectMapper().reader(FinishedGood).readValue(inputStream)

        println finishedGood

    }

    @Test
    public void shouldMarshalTestDataFromXml() throws Exception {

        def finishedGood = new XmlSlurper().parse(getClass().getResourceAsStream("/data/drug/finishedGood.xml"))

        println finishedGood.identifier.@value


    }
}
