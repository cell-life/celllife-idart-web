package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.type.TypeReference
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 10h10
 */
class ExplicitTypeReferenceTest {


    @Test
    public void testName() throws Exception {

        def reference = new TypeReference<List<Integer>>() {}
        println reference

    }
}
