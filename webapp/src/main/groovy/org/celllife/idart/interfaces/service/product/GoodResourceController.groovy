package org.celllife.idart.interfaces.service.product

import org.celllife.idart.application.product.GoodResourceService
import org.celllife.idart.domain.product.Good
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
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class GoodResourceController {

    @Autowired GoodResourceService goodResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/goods",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Good> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        goodResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/goods/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Good findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        goodResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    void save(@RequestBody Good good, HttpServletResponse response) {

        good = goodResourceService.save(good)

        response.setHeader("Location", "${baseUrl}/service/goods/${good.pk}")
        response.setStatus(SC_CREATED)
    }
}
