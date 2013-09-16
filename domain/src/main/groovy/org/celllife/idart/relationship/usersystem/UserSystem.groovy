package org.celllife.idart.relationship.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class UserSystem {

    Long pk

    UserId fromUser

    SystemId toSystem

    UserSystemRelationship relationship

}
