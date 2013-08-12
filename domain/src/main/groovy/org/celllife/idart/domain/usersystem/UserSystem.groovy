package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.SystemIdentifier
import org.celllife.idart.common.UserIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class UserSystem {

    Long pk

    UserIdentifier fromUser

    SystemIdentifier toSystem

    UserSystemRelationship relationship

}
