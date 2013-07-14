package org.celllife.idart.interfaces.service.unitofmeasure

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureRepository
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.celllife.idart.integration.ucum.UcumTsvFileReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_OK

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 09h05
 */
@Controller class UnitOfMeasureServiceController {

    @Autowired UcumTsvFileReader ucumTsvFileReader

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired ObjectMapper objectMapper

    @RequestMapping(value = "/service/unitsOfMeasure/upload", method = RequestMethod.POST)
    void upload(@RequestParam("structure") String structure,
                @RequestBody byte[] fileContent,
                HttpServletResponse response) {

        unitOfMeasureService.save(getUnitsOfMeasure(fileContent, structure))

        response.status = SC_OK
    }

    private List<UnitOfMeasure> getUnitsOfMeasure(byte[] fileContent, String structure) {
        InputStream inputStream = new ByteArrayInputStream(fileContent)

        switch (structure) {
            case "idart":
                return readUnitsOfMeasure(inputStream)
            case "ucum":
                return ucumTsvFileReader.readFile(inputStream)
        }
    }

    List<UnitOfMeasure> readUnitsOfMeasure(InputStream inputStream) {
        objectMapper.reader(new TypeReference<List<UnitOfMeasure>>() {}).readValue(inputStream)
    }
}
