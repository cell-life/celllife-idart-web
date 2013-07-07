package org.celllife.idart.integration.ucum

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.junit.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h45
 */
class UcumCodeFileReaderTest {

    @Test
    void shouldReadUcumXlm() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/ucum/ucum-essence.xml")
        List<UnitOfMeasure> unitsOfMeasure = UcumCodeFileReader.readFile(inputStream)

        Assert.assertNotNull(unitsOfMeasure)
        Assert.assertFalse(unitsOfMeasure.isEmpty())

    }
}
