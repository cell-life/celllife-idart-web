package org.celllife.idart.framework.bean

import junit.framework.Assert
import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 10h02
 */
class BeanMapperTest {

    @Test
    void shouldCopyProperties() {

        UnitOfMeasure milligrams = new UnitOfMeasure()
        milligrams.addName("en", "Milligrams")
        milligrams.addCode("http://unitsofmeasure.org", "mg")

        RawMaterial source = new RawMaterial(pk: 1L, unitOfMeasure: milligrams)
        source.addIdentifier("http://www.who.int/medicines/services/inn", "Abacavir")

        def target = BeanMapper.map(source, null)

        Assert.assertFalse(source.is(target))
        Assert.assertEquals(source, target)
    }

}
