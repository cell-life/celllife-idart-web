package org.celllife.idart.infrastructure.springdata.user;

import org.celllife.idart.common.UserId;
import org.celllife.idart.domain.user.User;
import org.celllife.idart.domain.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
public interface SpringDataUserRepository extends UserRepository,
        PagingAndSortingRepository<User, UserId> {

    @Query("select user.id from User user where user.username = :username")
    UserId findByUsername(@Param("username") String username);
}
