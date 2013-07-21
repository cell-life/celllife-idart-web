package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.FinishedGoodResourceService
import org.celllife.idart.domain.part.FinishedGood
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class FinishedGoodResourceController {

    @Autowired FinishedGoodResourceService finishedGoodResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/finishedGoods",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<FinishedGood> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        finishedGoodResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/finishedGoods/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    FinishedGood findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        finishedGoodResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/finishedGoods", method = RequestMethod.POST)
    void save(@RequestBody FinishedGood finishedGood, HttpServletResponse response) {

        finishedGood = finishedGoodResourceService.save(finishedGood)

        response.setHeader("Location", "${baseUrl}/service/finishedGoods/${finishedGood.pk}")
        response.setStatus(SC_CREATED)
    }
}
