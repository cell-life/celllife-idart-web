package org.celllife.idart.security.authority

import org.celllife.idart.application.authority.dto.AuthorityDto
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.authority.AuthorityApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AuthoritySecurityAdapter {

    @Inject AuthorityApplicationService authorityApplicationService

    AuthorityId save(Principal principal, authorityDto) {
        authorityApplicationService.save(authorityDto)
    }

    AuthorityDto findByAuthorityId(Principal principal, AuthorityId authorityId) {
        authorityApplicationService.findByAuthorityId(authorityId)
    }

    AuthorityDto findByIdentifier(Principal principal, Identifier identifier) {
        authorityApplicationService.findByIdentifier(identifier)
    }

}
