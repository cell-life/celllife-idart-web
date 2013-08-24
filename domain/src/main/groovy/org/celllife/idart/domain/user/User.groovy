package org.celllife.idart.domain.user

import org.celllife.idart.common.UserId

/**
 * User 
 *
 */
class User {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/users"

    /**
     * Id 
     */
    UserId id

    /**
     * Current Username 
     */
    String currentUsername

    /**
     * Current Password 
     */
    String currentPassword
}
