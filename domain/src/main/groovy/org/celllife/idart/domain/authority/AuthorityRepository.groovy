package org.celllife.idart.domain.authority

import org.celllife.idart.common.AuthorityId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AuthorityRepository {

    boolean exists(AuthorityId authorityId)

    Authority save(Authority authority)

    Authority findOne(AuthorityId authorityId)

}
