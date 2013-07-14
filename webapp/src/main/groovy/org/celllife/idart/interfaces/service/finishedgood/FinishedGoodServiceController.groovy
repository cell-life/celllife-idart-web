package org.celllife.idart.interfaces.service.finishedgood

import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
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
@Controller class FinishedGoodServiceController {

    @Autowired FinishedGoodService finishedGoodService

    @RequestMapping(value = "/service/finishedGoods", method = RequestMethod.POST)
    void save(@RequestBody FinishedGood finishedGood, HttpServletResponse response) {

        finishedGoodService.save(finishedGood)

        response.setStatus(HttpServletResponse.SC_OK)
    }
}
