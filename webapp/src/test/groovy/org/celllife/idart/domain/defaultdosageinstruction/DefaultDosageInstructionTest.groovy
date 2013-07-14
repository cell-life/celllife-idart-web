package org.celllife.idart.domain.defaultdosageinstruction

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 23h30
 */
class DefaultDosageInstructionTest {

    private ObjectMapper mapper

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper()
    }

    @Test
    public void shouldReadFromJson() throws Exception {

        def inputStream = getClass().getResourceAsStream("/data/defaultDosageInstruction/001.json")

        def defaultDosageInstruction = mapper.reader(DefaultDosageInstruction).readValue(inputStream)
        println defaultDosageInstruction

    }
}
