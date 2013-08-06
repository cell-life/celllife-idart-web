package org.celllife.idart.integration.ucum

import com.xlson.groovycsv.CsvParser
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util.regex.Pattern

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 11h45
 */
@Component class UcumTsvFileReader {

    @Autowired UnitOfMeasureTypeService unitOfMeasureTypeService;

    List<UnitOfMeasure> readFile(InputStream inputStream) {

        def reader = new InputStreamReader(inputStream)
        def rows = CsvParser.parseCsv([separator: '\t', quoteChar: ''], reader)

        rows.collect { row ->
            def unitOfMeasure = new UnitOfMeasure()

            def pattern = Pattern.compile("([^\\[]*) \\[([^\\]]*)\\]")
            def matcher = pattern.matcher(row.'Descriptive Name')
            if (matcher.matches()) {
                unitOfMeasure.name = matcher.group(1)
                unitOfMeasure.type = unitOfMeasureTypeService.save(new UnitOfMeasureType(code: matcher.group(2)))
            }

            unitOfMeasure.code = row.Code
            unitOfMeasure
        }
    }
}

