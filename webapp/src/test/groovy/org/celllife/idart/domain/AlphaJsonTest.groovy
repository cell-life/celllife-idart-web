package org.celllife.idart.domain

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-09
 * Time: 15h48
 */
class AlphaJsonTest {

    @Test
    public void testName() throws Exception {

        def objectMapper = new ObjectMapper()
        objectMapper.addMixInAnnotations(Alpha, AlphaMixin)

        Alpha alpha = objectMapper.reader(Alpha).readValue("""{
    "id" : "000001",
    "name" : "Geoff",
    "description" : "The Geoffster"
}""")

        Assert.assertNotNull(alpha)
        Assert.assertTrue(alpha instanceof AlphaImpl)
        Assert.assertEquals("000001", alpha.id)
        Assert.assertEquals("Geoff", alpha.name)
        Assert.assertEquals("The Geoffster", alpha.description)

    }

    @Test
    public void testSerialize() throws Exception {

        def objectMapper = new ObjectMapper()
        objectMapper.addMixInAnnotations(Alpha, AlphaMixin)

        def alpha = new AlphaImpl(id: "00001", name: "Geoff", description: "The Geoffster")

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(System.out, alpha)
    }
}
