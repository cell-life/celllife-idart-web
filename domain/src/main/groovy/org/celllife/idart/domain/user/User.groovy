package org.celllife.idart.domain.user

import org.celllife.idart.common.UserIdentifier

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
     * Identifier 
     */
    UserIdentifier identifier

    /**
     * Current Username 
     */
    String currentUsername

    /**
     * Current Password 
     */
    String currentPassword
}