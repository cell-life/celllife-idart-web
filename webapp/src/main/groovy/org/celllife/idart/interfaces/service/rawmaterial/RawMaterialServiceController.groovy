package org.celllife.idart.interfaces.service.rawmaterial

import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_OK

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 09h44
 */
@Controller class RawMaterialServiceController {

    @Autowired RawMaterialService rawMaterialService

    @RequestMapping(value = "/service/rawMaterials", method = RequestMethod.POST)
    void save(@RequestBody RawMaterial rawMaterial, HttpServletResponse response) {

        rawMaterialService.save(rawMaterial)

        response.setStatus(SC_OK)
    }

}
