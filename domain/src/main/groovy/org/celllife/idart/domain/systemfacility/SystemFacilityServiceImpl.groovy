package org.celllife.idart.domain.systemfacility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityIdentifier
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemIdentifier
import org.celllife.idart.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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
            systemFacilityRepository.findBySystemIdentifierAndFacilityIdentifierAndRelationship(
                    systemIdentifier,
                    facilityIdentifier,
                    DEPLOYED_AT
            )

        if (existingRelationship == null) {
            existingRelationship = systemFacilityRepository.save(
                    new SystemFacility(
                            fromSystem: new System(systemIdentifier: systemIdentifier),
                            toFacility: new Facility(facilityIdentifier: facilityIdentifier),
                            relationship: DEPLOYED_AT

                    )
            )
        }

        systemFacilityEventPublisher.userSystemSaved(existingRelationship)
    }
}
