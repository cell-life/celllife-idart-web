package org.celllife.idart.framework.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User

import java.security.Principal

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 22h14
 */
class Principals {

    static User getUser(Principal principal) {

        if (principal instanceof Authentication) {

            def authentication = (Authentication) principal

            if (authentication.principal instanceof User) {
                return authentication.principal as User
            }
        }

        throw new IllegalArgumentException("Principal of type [${principal.class}] is not supported.")
    }

}
