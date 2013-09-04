package org.celllife.idart.application.authority

import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.authority.Authority

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AuthorityApplicationService {

    Authority save(Authority authority)

    Authority findByAuthorityId(AuthorityId authorityId)

}
