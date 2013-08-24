package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId
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
    void saveUserForSystem(UserId fromUser, SystemId toSystem) {

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
