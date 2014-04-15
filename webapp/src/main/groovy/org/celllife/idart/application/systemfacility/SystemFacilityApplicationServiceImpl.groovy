package org.celllife.idart.application.systemfacility

import org.celllife.idart.application.systemfacility.dto.SystemFacilityDto
import org.celllife.idart.application.systemfacility.dto.SystemFacilityDtoAssembler
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h22
 */
@Named class SystemFacilityApplicationServiceImpl implements SystemFacilityApplicationService {

    @Inject SystemFacilityService systemFacilityService

    @Inject SystemFacilityDtoAssembler systemFacilityDtoAssembler

    @Override
    @Transactional
    void save(SystemFacilityDto systemFacilityDto) {

        def systemFacility = systemFacilityDtoAssembler.toSystemFacility(systemFacilityDto)

        systemFacilityService.save(systemFacility)
    }
}
