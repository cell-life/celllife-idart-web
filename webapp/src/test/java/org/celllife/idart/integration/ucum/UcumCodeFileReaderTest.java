package org.celllife.idart.integration.ucum;

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h45
 */
public class UcumCodeFileReaderTest {

    @Test
    public void shouldReadUcumXlm() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/ucum/ucum-essence.xml");
        List<UnitOfMeasure> unitsOfMeasure = UcumCodeFileReader.readFile(inputStream);

        Assert.assertNotNull(unitsOfMeasure);
        Assert.assertFalse(unitsOfMeasure.isEmpty());

    }
}
