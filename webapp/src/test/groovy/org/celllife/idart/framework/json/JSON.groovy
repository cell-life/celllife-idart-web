package org.celllife.idart.framework.json

import groovy.json.JsonSlurper
import org.junit.Assert

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h31
 */
class JSON {

    static readFromClasspath(String classpathLocation) {

        def inputStream = getClass().getResourceAsStream(classpathLocation)

        Assert.assertNotNull(inputStream)

        new JsonSlurper().parse(new InputStreamReader(inputStream))
    }
}
