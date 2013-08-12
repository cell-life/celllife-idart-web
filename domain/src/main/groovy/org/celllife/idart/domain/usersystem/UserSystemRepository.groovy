package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.SystemIdentifier
import org.celllife.idart.common.UserIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h14
 */
interface UserSystemRepository {

    UserSystem save(UserSystem userForSystem)

    UserSystem findByUserAndSystemAndRelationship(UserIdentifier fromUser,
                                                                      SystemIdentifier toSystem,
                                                                      UserSystemRelationship relationship)
}
