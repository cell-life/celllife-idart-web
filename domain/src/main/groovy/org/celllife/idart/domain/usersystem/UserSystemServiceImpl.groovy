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
    void saveUserForSystem(UserIdentifier userIdentifier, SystemIdentifier systemIdentifier) {

        def existingRelationship =
            userSystemRepository.findByUserIdentifierAndSystemIdentifierAndRelationship(
                userIdentifier,
                systemIdentifier,
                FOR
            )

        if (existingRelationship == null) {
            existingRelationship = userSystemRepository.save(
                    new UserSystem(
                            fromUser: new User(userIdentifier: userIdentifier),
                            toSystem: new System(systemIdentifier: systemIdentifier),
                            relationship: FOR

                    )
            )
        }

        userSystemEventPublisher.publish(newUserSystemEvent(existingRelationship))
    }

    static newUserSystemEvent(UserSystem existingRelationship) {
        new UserSystemEventFactory().username("").userSystem(existingRelationship).build()
    }
}
