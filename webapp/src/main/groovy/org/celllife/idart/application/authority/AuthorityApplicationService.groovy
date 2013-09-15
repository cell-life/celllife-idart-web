package org.celllife.idart.application.authority

import org.celllife.idart.application.authority.dto.AuthorityDto
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AuthorityApplicationService {

    Boolean exists(AuthorityId authorityId)

    AuthorityId save(AuthorityDto authorityDto)

    AuthorityDto findByAuthorityId(AuthorityId authorityId)

    AuthorityDto findByIdentifier(Identifier identifier)

}
