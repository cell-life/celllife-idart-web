package org.celllife.idart.infrastructure.springdata.usersystem;

import org.celllife.idart.common.SystemId;
import org.celllife.idart.common.UserId;
import org.celllife.idart.domain.usersystem.UserSystem;
import org.celllife.idart.domain.usersystem.UserSystemRelationship;
import org.celllife.idart.domain.usersystem.UserSystemRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-12
 * Time: 16h01
 */
public interface SpringDataUserSystemRepository extends UserSystemRepository,
        PagingAndSortingRepository<UserSystem, Long> {

    @Query("select userSystem from UserSystem userSystem " +
            "where userSystem.fromUser = :fromUser " +
            "and userSystem.toSystem = :toSystem " +
            "and userSystem.relationship = :relationship")
    UserSystem findByUserAndSystemAndRelationship(@Param("fromUser") UserId fromUser,
                                                  @Param("toSystem") SystemId toSystem,
                                                  @Param("relationship") UserSystemRelationship relationship);
}
