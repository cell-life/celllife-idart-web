package org.celllife.idart.application.authority

import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.authority.Authority
import org.celllife.idart.domain.authority.AuthorityService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AuthorityApplicationServiceImpl implements AuthorityApplicationService {

    @Inject AuthorityService authorityService

    Authority save(Authority authority) {
        authorityService.save(authority)
    }

    Authority findByAuthorityId(AuthorityId authorityId) {
        authorityService.findByAuthorityId(authorityId)
    }

}
