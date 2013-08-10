package org.celllife.idart.domain.user

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
    UserIdentifier userIdentifier

    /**
     * Current Username 
     */
    String currentUsername

    /**
     * Current Password 
     */
    String currentPassword
}