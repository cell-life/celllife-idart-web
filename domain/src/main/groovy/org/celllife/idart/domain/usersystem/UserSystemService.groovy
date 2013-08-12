package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.SystemIdentifier
import org.celllife.idart.common.UserIdentifier


/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
interface UserSystemService {

    void saveUserForSystem(UserIdentifier fromUser, SystemIdentifier toSystem)

}