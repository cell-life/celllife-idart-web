package org.celllife.idart.relationship.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId


/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
interface UserSystemService {

    void saveUserForSystem(UserId fromUser, SystemId toSystem)

}
