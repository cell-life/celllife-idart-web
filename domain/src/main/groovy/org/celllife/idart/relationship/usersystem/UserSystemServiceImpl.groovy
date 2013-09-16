package org.celllife.idart.relationship.usersystem

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.UserId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.relationship.usersystem.UserSystemEvent.EventType.SAVED
import static org.celllife.idart.relationship.usersystem.UserSystemEvent.newUserSystemEvent
import static org.celllife.idart.relationship.usersystem.UserSystemRelationship.FOR

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
@Named class UserSystemServiceImpl implements UserSystemService {

    @Inject UserSystemRepository userSystemRepository

    @Inject UserSystemEventPublisher userSystemEventPublisher

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
