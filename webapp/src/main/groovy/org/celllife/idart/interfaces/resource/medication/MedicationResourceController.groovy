package org.celllife.idart.interfaces.resource.medication

import org.celllife.idart.application.medication.MedicationApplicationService
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.common.ProductId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class MedicationResourceController {

    @Autowired MedicationApplicationService medicationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/medications/{productId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Medication findByProductId(@PathVariable("productId") ProductId productId) {
        medicationApplicationService.findByProductId(productId)
    }

    @RequestMapping(value = "/medications", method = RequestMethod.POST)
    void save(@RequestBody Medication medication, HttpServletResponse response) {

        medication = medicationApplicationService.save(medication)

        response.setHeader("Location", "${baseUrl}/medications/${medication.id}")
        response.setStatus(SC_CREATED)
    }
}
