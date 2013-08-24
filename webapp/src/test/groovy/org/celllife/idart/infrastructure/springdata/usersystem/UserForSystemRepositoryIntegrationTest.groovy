package org.celllife.idart.infrastructure.springdata.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemService
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserService
import org.celllife.idart.domain.usersystem.UserSystemService
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

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

        def userId = new UserId(value: "00001")
        def user = new User(id: userId)
        userService.save(user)

        userService.findByUserId(new UserId(value: "00001"))

        def systemId = new SystemId(value: "00002")
        def system = new System(id: systemId)
        systemService.save(system)

        userForSystemService.saveUserForSystem(userId, systemId)

        sleep(5000)

    }
}
