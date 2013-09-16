package org.celllife.idart.application.authority.dto

import org.celllife.idart.domain.authority.Authority
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AuthorityDtoAssembler {

    Authority toAuthority(AuthorityDto authorityDto) {

        def authority = new Authority()
        authority.with {

        }

        authority
    }

    AuthorityDto toAuthorityDto(Authority authority) {

        def authorityDto = new AuthorityDto()
        authorityDto.with {

        }

        authorityDto
    }
}
