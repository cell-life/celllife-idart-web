package org.celllife.idart.infrastructure.jackson.part

import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Part
import org.celllife.idart.framework.json.IdartObjectMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h13
 */
class PartDtoMixinTest {

    IdartObjectMapper objectMapper

    @Before
    public void setUp() throws Exception {
        objectMapper = new IdartObjectMapper()
    }

    @Test
    public void testDeserialize() throws Exception {

        def json = """{
    "type": "COMPOUND",
    "label": "Zidovudine"
}"""

        def part = objectMapper.readValue(json, Part.class)

        assertNotNull(part)
        assertTrue(part instanceof Compound)
    }
}
