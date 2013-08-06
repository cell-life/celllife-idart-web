package org.celllife.idart.domain.usersystem

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.user.User

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class UserSystem {

    Long pk

    User fromUser

    System toSystem

    UserSystemRelationship relationship

}
