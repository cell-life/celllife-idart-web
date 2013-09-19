package org.celllife.idart.relationship.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId
import org.celllife.idart.relationship.systemfacility.SystemFacility

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.Period.newPeriod

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
@Named class SystemFacilityServiceImpl implements SystemFacilityService {

    @Inject SystemFacilityRepository systemFacilityRepository

    @Override
    void save(SystemFacility systemFacility) {
        save(systemFacility.system, systemFacility.facility, systemFacility.relationship)
    }

    @Override
    void save(SystemId system, FacilityId facility, SystemFacility.Relationship relationship) {

        def systemFacility = systemFacilityRepository
                .findBySystemFacilityRelationshipValid(system, facility, relationship, new Date())

        if (systemFacility == null) {
            systemFacility = new SystemFacility(
                    system: system,
                    facility: facility,
                    relationship: relationship,
                    valid: newPeriod()
            )

            systemFacilityRepository.save(systemFacility)
        }
    }

    @Override
    FacilityId findFacility(SystemId system, SystemFacility.Relationship relationship) {

        def systemFacility = systemFacilityRepository
                .findBySystemRelationshipValid(system, relationship, new Date())

        systemFacility?.facility
    }

    @Override
    SystemId findSystem(FacilityId facilityId, SystemFacility.Relationship relationship) {

        def systemFacility = systemFacilityRepository
                .findByFacilityRelationshipValid(facilityId, relationship, new Date())

        systemFacility?.system
    }
}
