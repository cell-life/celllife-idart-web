package org.celllife.idart.common

import org.junit.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-11
 * Time: 16h21
 */
class PartyClassificationCodeTest {

    @Test
    public void shouldGetValueOfPartyClassification() throws Exception {

        Assert.assertEquals("0009", PartyClassificationCode.valueOf("SIC-0009").value)
        Assert.assertEquals(PartyClassificationType.SIC, PartyClassificationCode.valueOf("SIC-0009").type)

        Assert.assertEquals("0009", PartyClassificationCode.valueOf("EE-0009").value)
        Assert.assertEquals(PartyClassificationType.EE, PartyClassificationCode.valueOf("EE-0009").type)
    }
}
