package org.celllife.idart.infrastructure.springdata.usersystem;

import org.celllife.idart.domain.system.SystemIdentifier;
import org.celllife.idart.domain.user.UserIdentifier;
import org.celllife.idart.domain.usersystem.UserSystem;
import org.celllife.idart.domain.usersystem.UserSystemRepository;
import org.celllife.idart.domain.usersystem.UserSystemRelationship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h15
 */
public interface SpringDataUserSystemRepository extends CrudRepository<UserSystem, Long>, UserSystemRepository {


    @Query("select userSystem " +
            "from UserSystem userSystem " +
            "where userSystem.fromUser.identifier = :user " +
            "and userSystem.toSystem.identifier = :system " +
            "and userSystem.relationship = :relationship ")
    UserSystem findByUserAndSystemAndRelationship(@Param("user") UserIdentifier user,
                                                  @Param("system") SystemIdentifier system,
                                                  @Param("relationship") UserSystemRelationship relationship);

}
