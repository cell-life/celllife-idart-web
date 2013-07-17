package org.celllife.idart.integration.ucum

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
class UcumCodeFileReaderIntegrationTest {

    @Autowired UcumTsvFileReader ucumCodeFileReader

    @Test
    void shouldReadUcumTsv() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/unitOfMeasure/ucum.tsv")
        List<UnitOfMeasure> unitsOfMeasures = ucumCodeFileReader.readFile(inputStream)

        Assert.assertNotNull(unitsOfMeasures)
        Assert.assertFalse(unitsOfMeasures.isEmpty())
    }
}
