package org.celllife.idart.interfaces.service.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.DefaultDosageInstructionApplicationService
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletResponse

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h00
 */
@Controller class DefaultDosageInstructionServiceController {

    @Autowired DefaultDosageInstructionApplicationService defaultDosageInstructionApplicationService

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/service/defaultDosageInstructions", method = RequestMethod.POST)
    void save(@RequestBody DefaultDosageInstruction defaultDosageInstruction, HttpServletResponse response) {

        defaultDosageInstruction = defaultDosageInstructionApplicationService.save(defaultDosageInstruction)

        response.setHeader("Location", "${baseUrl}/service/defaultDosageInstructions/${defaultDosageInstruction.pk}")
        response.setStatus(HttpServletResponse.SC_OK)
    }

}
