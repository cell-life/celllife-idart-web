package org.celllife.idart.infrastructure.springdata.user;

import org.celllife.idart.common.UserId;
import org.celllife.idart.domain.user.User;
import org.celllife.idart.domain.user.UserRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataUserRepository extends UserRepository,
        PagingAndSortingRepository<User, UserId> {

}
