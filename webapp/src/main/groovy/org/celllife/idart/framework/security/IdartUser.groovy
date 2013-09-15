package org.celllife.idart.framework.security

import org.celllife.idart.common.PersonId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 22h11
 */
class IdartUser extends User {

    PersonId person

    IdartUser(String username, String password, Collection<? extends GrantedAuthority> authorities, PersonId person) {
        super(username, password, authorities)
        this.person = person
    }
}
