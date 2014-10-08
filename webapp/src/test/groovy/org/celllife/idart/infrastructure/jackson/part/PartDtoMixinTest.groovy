package org.celllife.idart.infrastructure.jackson.part

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.framework.json.IdartObjectMapper
import org.junit.Before
import org.junit.Test


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

        def part = objectMapper.readValue(json, PartDto.class)

        assertNotNull(part)
        assertTrue(part instanceof CompoundDto)
    }
}
