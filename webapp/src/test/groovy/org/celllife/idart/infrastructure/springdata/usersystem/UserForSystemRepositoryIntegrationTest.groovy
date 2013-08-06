package org.celllife.idart.infrastructure.springdata.usersystem

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemIdentifier
import org.celllife.idart.domain.system.SystemService
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserIdentifier
import org.celllife.idart.domain.user.UserService
import org.celllife.idart.domain.usersystem.UserSystem
import org.celllife.idart.domain.usersystem.UserSystemRelationship
import org.celllife.idart.domain.usersystem.UserSystemService
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.domain.usersystem.UserSystemRelationship.FOR

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h22
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class UserForSystemRepositoryIntegrationTest {

    @Autowired UserService userService

    @Autowired SystemService systemService

    @Autowired UserSystemService userForSystemService

    @Test
    public void shouldSave() throws Exception {

        def userIdentifier = new UserIdentifier(value: "00001")
        def user = new User(identifier: userIdentifier)
        userService.save(user)

        userService.findByIdentifier(new UserIdentifier(value: "00001"))

        def systemIdentifier = new SystemIdentifier(value: "00002")
        def system = new System(identifier: systemIdentifier)
        systemService.save(system)

        userForSystemService.saveUserForSystem(userIdentifier, systemIdentifier)

        sleep(5000)

    }
}
