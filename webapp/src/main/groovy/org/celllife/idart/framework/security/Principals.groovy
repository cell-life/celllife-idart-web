package org.celllife.idart.framework.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
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

    static String getCurrentUsername() {

        Object principal = SecurityContextHolder.context?.authentication?.principal

        if (principal == null) {
            return null
        }

        if (principal instanceof Authentication) {

            def authentication = (Authentication) principal

            if (authentication.principal instanceof User) {
                return (authentication.principal as User).username
            }

            if (authentication.principal instanceof String) {
                return authentication.principal as String
            }

        }

        return null
    }

}
