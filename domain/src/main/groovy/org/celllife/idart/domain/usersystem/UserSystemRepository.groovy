package org.celllife.idart.domain.usersystem

import org.celllife.idart.domain.system.SystemIdentifier
import org.celllife.idart.domain.user.UserIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h14
 */
interface UserSystemRepository {

    UserSystem save(UserSystem userForSystem)

    UserSystem findByUserIdentifierAndSystemIdentifierAndRelationship(UserIdentifier user,
                                                  SystemIdentifier system,
                                                  UserSystemRelationship relationship)
}
