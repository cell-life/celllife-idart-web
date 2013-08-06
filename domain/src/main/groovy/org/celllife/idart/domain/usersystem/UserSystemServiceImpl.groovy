package org.celllife.idart.domain.usersystem

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemIdentifier
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserIdentifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.usersystem.UserSystemRelationship.FOR

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
@Service class UserSystemServiceImpl implements UserSystemService {

    @Autowired UserSystemRepository userSystemRepository

    @Autowired UserSystemEventPublisher userSystemEventPublisher

    @Override
    void saveUserForSystem(UserIdentifier user, SystemIdentifier system) {

        def existingRelationship = userSystemRepository.findByUserAndSystemAndRelationship(user, system, FOR)

        if (existingRelationship == null) {
            existingRelationship = userSystemRepository.save(
                    new UserSystem(
                            fromUser: new User(identifier: user),
                            toSystem: new System(identifier: system),
                            relationship: FOR

                    )
            )
        }

        userSystemEventPublisher.userSystemSaved(existingRelationship)
    }
}
