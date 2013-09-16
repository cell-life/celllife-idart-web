package org.celllife.idart.relationship.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h14
 */
interface UserSystemRepository {

    UserSystem save(UserSystem userForSystem)

    UserSystem findByUserAndSystemAndRelationship(UserId fromUser,
                                                                      SystemId toSystem,
                                                                      UserSystemRelationship relationship)
}
