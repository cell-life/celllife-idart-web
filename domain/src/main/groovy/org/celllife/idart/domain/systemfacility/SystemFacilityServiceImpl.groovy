package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.systemfacility.SystemFacilityEvent.EventType.SAVED
import static org.celllife.idart.domain.systemfacility.SystemFacilityEvent.newSystemFacilityEvent
import static org.celllife.idart.domain.systemfacility.SystemFacilityRelationship.DEPLOYED_AT

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
@Named class SystemFacilityServiceImpl implements SystemFacilityService {

    @Inject SystemFacilityRepository systemFacilityRepository

    @Inject SystemFacilityEventPublisher systemFacilityEventPublisher

    @Override
    void saveUserForSystem(SystemId systemId, FacilityId facilityId) {

        def existingRelationship =
            systemFacilityRepository.findBySystemAndFacilityAndRelationship(
                    systemId,
                    facilityId,
                    DEPLOYED_AT
            )

        if (existingRelationship == null) {
            existingRelationship = systemFacilityRepository.save(
                    new SystemFacility(
                            fromSystem: systemId,
                            toFacility: facilityId,
                            relationship: DEPLOYED_AT

                    )
            )
        }

        systemFacilityEventPublisher.publish(newSystemFacilityEvent(existingRelationship, SAVED))
    }
}
