package org.celllife.idart.interfaces.service.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService
import org.celllife.idart.integration.hl7.CodeFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_OK
import static org.celllife.idart.integration.hl7.Hl7CodeFileReader.readFile

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h03
 */
@Controller class RouteOfAdministrationServiceController {

    @Autowired RouteOfAdministrationService routeOfAdministrationService

    @RequestMapping(value = "/routes/upload", method = RequestMethod.POST)
    void upload(@RequestParam("structure") String structure,
                @RequestBody byte[] fileContent,
                HttpServletResponse response) {

        switch (structure) {
            case "hl7":
                routeOfAdministrationService.save(getRouteOfAdministrationsFromHl7(fileContent))
                break
        }

        response.status = SC_OK
    }

    static List<RouteOfAdministration> getRouteOfAdministrationsFromHl7(byte[] fileContent) {

        CodeFile codeFile = readFile("HL7v3 RouteOfAdministration", new ByteArrayInputStream(fileContent))
        if (codeFile == null) {
            return []
        }

        codeFile.codes.collect { code ->
            RouteOfAdministration routeOfAdministration = new RouteOfAdministration(name: code.name)
            routeOfAdministration.addCode(codeFile.system, code.code)
            routeOfAdministration
        }
    }
}
