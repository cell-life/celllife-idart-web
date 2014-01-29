package org.celllife.idart.security.part

import java.security.Principal

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.part.AtcCodeApplicationService
import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.framework.security.IdartSystem
import org.celllife.idart.framework.security.IdartUser

import static org.celllife.idart.framework.security.Principals.getUser

/**
 * Security Adapter for the ATC Code application service. This adapter handles all dealings
 * with the Principal and will convert into a domain object understood by the application service.
 * It is used by the AtcCodeResourceController
 */
@Named class AtcCodeSecurityAdapter {

	@Inject AtcCodeApplicationService atcCodeApplicationService

	Set<AtcCodeDto> findAll(Principal principal) {

		def user = getUser(principal)

		if (user instanceof IdartSystem) {
			return atcCodeApplicationService.findBySystem((user as IdartSystem).id)
		}

		if (user instanceof IdartUser) {
			return atcCodeApplicationService.findByPerson((user as IdartUser).person)
		}

		throw new IllegalArgumentException("Principal of type [${principal.class}] is not supported.")
	}
}
