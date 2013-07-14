package org.celllife.idart.domain.unitofmeasure

import junit.framework.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-07
 * Time: 10h32
 */
class UnitOfMeasureTest {

    @Test
    public void shouldSetDefaultName() throws Exception {

        def measure = new UnitOfMeasure()
        measure.name = "Geoff"

        Assert.assertEquals("Geoff", measure.name)
    }

    @Test
    public void shouldSetCode() throws Exception {

        def idartSystem = "http://www.cell-life.org/idart/unitOfMeasure"

        def measure = new UnitOfMeasure()
        measure.addCode(idartSystem, "each")

        Assert.assertEquals("each", measure.getCodeValue(idartSystem))
    }
}
