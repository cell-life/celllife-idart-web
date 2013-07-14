package org.celllife.idart.integration.ucum

import com.xlson.groovycsv.CsvParser
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util.regex.Pattern

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 11h45
 */
@Component class UcumTsvFileReader {

    @Autowired UnitOfMeasureTypeRepository unitOfMeasureTypeRepository;

    List<UnitOfMeasure> readFile(InputStream inputStream) {

        def reader = new InputStreamReader(inputStream)
        def rows = CsvParser.parseCsv([separator: '\t', quoteChar: ''], reader)

        rows.collect { row ->
            def unitOfMeasure = new UnitOfMeasure()

            def pattern = Pattern.compile("([^\\[]*) \\[([^\\]]*)\\]")
            def matcher = pattern.matcher(row.'Descriptive Name')
            if (matcher.matches()) {
                unitOfMeasure.name = matcher.group(1)

                def unitOfMeasureTypeName = matcher.group(2)

                def unitOfMeasureType = unitOfMeasureTypeRepository.findOneByName("en", unitOfMeasureTypeName)
                if (unitOfMeasureType == null) {
                    unitOfMeasureType = new UnitOfMeasureType(name: unitOfMeasureTypeName)
                    unitOfMeasureType = unitOfMeasureTypeRepository.save(unitOfMeasureType)
                }
                unitOfMeasure.type = unitOfMeasureType
            }

            unitOfMeasure.addCode("http://unitsofmeasure.org", row.Code)
            unitOfMeasure
        }
    }
}

