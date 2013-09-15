package org.celllife.idart.framework.security

import org.celllife.idart.domain.user.UserService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 21h51
 */
@Named class IdartUserDetailService implements UserDetailsService {

    @Inject UserService userService

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        def userId = userService.findByUsername(username)

        def user = userService.findByUserId(userId)

        return new IdartUser(username, user.password, [] as Collection<? extends GrantedAuthority>);
    }
}
