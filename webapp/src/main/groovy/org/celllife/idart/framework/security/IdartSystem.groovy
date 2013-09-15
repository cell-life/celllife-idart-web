package org.celllife.idart.framework.security

import org.celllife.idart.common.SystemId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

import static org.celllife.idart.common.SystemId.systemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 22h11
 */
class IdartSystem extends User {

    IdartSystem(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities)
    }

    SystemId getId() {
        systemId(username)
    }
}
