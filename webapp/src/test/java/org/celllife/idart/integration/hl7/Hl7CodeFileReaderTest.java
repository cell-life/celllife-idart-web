package org.celllife.idart.integration.hl7;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h45
 */
public class Hl7CodeFileReaderTest {

    @Test
    public void shouldReadOrderableDrugFormXls() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/hl7/OrderableDrugForm.xls");
        CodeFile codeFile = Hl7CodeFileReader.readFile("HL7v3 MaterialForm", inputStream);

        Assert.assertNotNull(codeFile);
        Assert.assertNotNull(codeFile.getCodes());
        Assert.assertFalse(codeFile.getCodes().isEmpty());
    }

    @Test
    public void shouldReadRouteOfAdministrationXls() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/hl7/RouteOfAdministration.xls");


        CodeFile codeFile = Hl7CodeFileReader.readFile("HL7v3 RouteOfAdministration", inputStream);

        Assert.assertNotNull(codeFile);
        Assert.assertNotNull(codeFile.getCodes());
        Assert.assertFalse(codeFile.getCodes().isEmpty());
    }
}
