package org.celllife.idart.interfaces.service.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService
import org.springframework.beans.factory.annotation.Autowired
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

    @Autowired DefaultDosageInstructionService defaultDosageInstructionService

    @RequestMapping(value = "/service/defaultDosageInstructions", method = RequestMethod.POST)
    void save(@RequestBody DefaultDosageInstruction defaultDosageInstruction, HttpServletResponse response) {

        defaultDosageInstructionService.save(defaultDosageInstruction)

        response.setStatus(HttpServletResponse.SC_OK)
    }

}
