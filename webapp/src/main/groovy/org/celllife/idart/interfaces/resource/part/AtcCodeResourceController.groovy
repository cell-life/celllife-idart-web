package org.celllife.idart.interfaces.resource.part

import static javax.servlet.http.HttpServletResponse.*

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.security.part.AtcCodeSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 */
@Controller class AtcCodeResourceController {

	@Inject AtcCodeSecurityAdapter atcCodeSecurityAdapter

	@Value('${external.base.url}') String baseUrl

	@ResponseBody
	@RequestMapping(value = "/atcCodes", method = RequestMethod.GET, produces = "application/json")
	Set<AtcCodeDto> findAll(Principal principal) {
		return atcCodeSecurityAdapter.findAll(principal)
	}
}
