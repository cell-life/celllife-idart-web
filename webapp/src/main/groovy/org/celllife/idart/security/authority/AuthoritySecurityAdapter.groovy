package org.celllife.idart.security.authority

import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.authority.Authority
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

    Authority save(Principal principal, Authority authority) {
        authorityApplicationService.save(authority)
    }

    Authority findByAuthorityId(Principal principal, AuthorityId authorityId) {
        authorityApplicationService.findByAuthorityId(authorityId)
    }

}
