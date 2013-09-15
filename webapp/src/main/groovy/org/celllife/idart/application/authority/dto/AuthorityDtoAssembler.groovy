package org.celllife.idart.application.authority.dto

import org.celllife.idart.domain.authority.Authority
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AuthorityDtoAssembler {

    static Authority toAuthority(AuthorityDto authorityDto) {

        def authority = new Authority()
        authority.with {

        }

        authority
    }

    static AuthorityDto toAuthorityDto(Authority authority) {

        def authorityDto = new AuthorityDto()
        authorityDto.with {

        }

        authorityDto
    }
}
