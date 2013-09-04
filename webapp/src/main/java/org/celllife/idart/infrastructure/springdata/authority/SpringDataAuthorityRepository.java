package org.celllife.idart.infrastructure.springdata.authority;

import org.celllife.idart.common.AuthorityId;
import org.celllife.idart.domain.authority.Authority;
import org.celllife.idart.domain.authority.AuthorityRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataAuthorityRepository extends AuthorityRepository,
        PagingAndSortingRepository<Authority, AuthorityId> {

}
