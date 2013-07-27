package org.celllife.idart.framework.groovy

import junit.framework.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-27
 * Time: 13h10
 */
class GroovyMixinAccessorTest {

    @Test(expected = StackOverflowError)
    public void testName() throws Exception {
        Assert.assertEquals("Geoff", new Alpha(name: "Geoff").name)
    }

    @Mixin(AlphaMixin)
    static class Alpha {
        String name
        Alpha() {
        }
    }

    static class AlphaMixin {
        def getName() {
            this.name
        }
    }
}
