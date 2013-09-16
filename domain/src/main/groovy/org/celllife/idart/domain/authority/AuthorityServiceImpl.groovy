package org.celllife.idart.domain.authority

import org.celllife.idart.common.AuthorityId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.authority.AuthorityEvent.EventType.SAVED
import static org.celllife.idart.domain.authority.AuthorityEvent.newAuthorityEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AuthorityServiceImpl implements AuthorityService {

    @Inject AuthorityRepository authorityRepository

    @Inject AuthorityValidator authorityValidator

    @Inject AuthorityEventPublisher authorityEventPublisher

    @Override
    Boolean exists(AuthorityId authorityId) {
        authorityRepository.exists(authorityId)
    }

    @Override
    Authority save(Authority authority) {

        def existingAuthority = authorityRepository.findOne(authority.id)

        if (existingAuthority == null) {
            existingAuthority = authority
        } else {
            existingAuthority.merge(authority)
        }

        authorityValidator.validate(existingAuthority)

        authorityEventPublisher.publish(newAuthorityEvent(existingAuthority, SAVED))

        authorityRepository.save(existingAuthority)
    }

    @Override
    Authority findByAuthorityId(AuthorityId authorityId) {

        def authority = authorityRepository.findOne(authorityId)

        if (authority == null) {
            throw new AuthorityNotFoundException("Could not find Authority with id [${ authorityId}]")
        }

        authority
    }
}
