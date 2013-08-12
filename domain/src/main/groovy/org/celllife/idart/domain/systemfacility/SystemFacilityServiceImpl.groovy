package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityIdentifier
import org.celllife.idart.common.SystemIdentifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.systemfacility.SystemFacilityEvent.EventType.SAVED
import static org.celllife.idart.domain.systemfacility.SystemFacilityEvent.newSystemFacilityEvent
import static org.celllife.idart.domain.systemfacility.SystemFacilityRelationship.DEPLOYED_AT

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
@Service class SystemFacilityServiceImpl implements SystemFacilityService {

    @Autowired SystemFacilityRepository systemFacilityRepository

    @Autowired SystemFacilityEventPublisher systemFacilityEventPublisher

    @Override
    void saveUserForSystem(SystemIdentifier systemIdentifier, FacilityIdentifier facilityIdentifier) {

        def existingRelationship =
            systemFacilityRepository.findBySystemAndFacilityAndRelationship(
                    systemIdentifier,
                    facilityIdentifier,
                    DEPLOYED_AT
            )

        if (existingRelationship == null) {
            existingRelationship = systemFacilityRepository.save(
                    new SystemFacility(
                            fromSystem: systemIdentifier,
                            toFacility: facilityIdentifier,
                            relationship: DEPLOYED_AT

                    )
            )
        }

        systemFacilityEventPublisher.publish(newSystemFacilityEvent(existingRelationship, SAVED))
    }
}
