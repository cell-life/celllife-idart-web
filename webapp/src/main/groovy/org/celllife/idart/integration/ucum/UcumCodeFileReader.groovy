package org.celllife.idart.integration.ucum

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 11h45
 */
class UcumCodeFileReader {

    static List<UnitOfMeasure> readFile(InputStream inputStream) {

        def root = new XmlSlurper().parse(inputStream)
        root.prefix.collect { prefix ->
            def unitOfMeasure = new UnitOfMeasure()
            unitOfMeasure.name = prefix.name.text()
            unitOfMeasure.addCode("http://unitsofmeasure.org", prefix.@CODE.text())
            unitOfMeasure

        }
    }
}

