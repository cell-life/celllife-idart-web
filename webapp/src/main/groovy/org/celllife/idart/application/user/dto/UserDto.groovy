package org.celllife.idart.application.user.dto

import org.celllife.idart.common.Identifier

/**
 */
class UserDto implements Serializable  {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Username
     */
    String username

    /**
     * Password
     */
    String password
}
