package org.celllife.idart.domain.user

import org.celllife.idart.common.PersonId
import org.celllife.idart.common.UserId

/**
 * User 
 *
 */
class User implements Serializable {

    /**
     * Id 
     */
    UserId id

    /**
     * Username
     */
    String username

    /**
     * Password
     */
    String password

    /**
     * Person
     */
    PersonId person

    def merge(User that) {

        if (that == null) {
            return
        }

        this.username = that.username
        this.password = that.password
        this.person = that.person
    }
}
