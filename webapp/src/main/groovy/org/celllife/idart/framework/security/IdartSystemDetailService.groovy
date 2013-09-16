package org.celllife.idart.framework.security

import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.domain.system.SystemService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.SystemId.systemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 21h51
 */
@Named class IdartSystemDetailService implements UserDetailsService {

    @Inject SystemService systemService

    @Override
    UserDetails loadUserByUsername(String systemIdValue) throws UsernameNotFoundException {

        try {

            def system = systemService.findBySystemId(systemId(systemIdValue))

            return new IdartSystem(system.id.value, system.applicationKey, [] as Collection<? extends GrantedAuthority>);

        } catch (SystemNotFoundException e) {

            throw new UsernameNotFoundException(e.message)
        }
    }
}
