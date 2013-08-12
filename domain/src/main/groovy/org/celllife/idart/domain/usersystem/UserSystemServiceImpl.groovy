package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.SystemIdentifier
import org.celllife.idart.common.UserIdentifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.usersystem.UserSystemEvent.EventType.SAVED
import static org.celllife.idart.domain.usersystem.UserSystemEvent.newUserSystemEvent
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
    void saveUserForSystem(UserIdentifier fromUser, SystemIdentifier toSystem) {

        def existingRelationship =
            userSystemRepository.findByUserAndSystemAndRelationship(fromUser, toSystem, FOR)

        if (existingRelationship == null) {
            existingRelationship = userSystemRepository.save(
                    new UserSystem(fromUser: fromUser, toSystem: toSystem, relationship: FOR)
            )
        }

        userSystemEventPublisher.publish(newUserSystemEvent(existingRelationship, SAVED))
    }
}
