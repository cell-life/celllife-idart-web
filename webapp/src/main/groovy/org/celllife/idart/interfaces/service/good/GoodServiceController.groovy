package org.celllife.idart.interfaces.service.good

import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.product.GoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletResponse

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 09h44
 */
@Controller class GoodServiceController {

    @Autowired GoodService GoodService

    @RequestMapping(value = "/service/goods", method = RequestMethod.POST)
    void save(@RequestBody Good good, HttpServletResponse response) {

        goodService.save(good)

        response.setStatus(HttpServletResponse.SC_OK)
    }
}
