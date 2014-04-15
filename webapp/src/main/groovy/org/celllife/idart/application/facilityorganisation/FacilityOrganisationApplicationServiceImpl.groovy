package org.celllife.idart.application.facilityorganisation

import org.celllife.idart.application.facilityorganisation.dto.FacilityOrganisationDto
import org.celllife.idart.application.facilityorganisation.dto.FacilityOrganisationDtoAssembler
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h45
 */
@Named class FacilityOrganisationApplicationServiceImpl implements FacilityOrganisationApplicationService {

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject FacilityOrganisationDtoAssembler facilityOrganisationDtoAssembler

    @Override
    @Transactional
    void save(FacilityOrganisationDto facilityOrganisationDto) {

        def facilityOrganisation = facilityOrganisationDtoAssembler.toFacilityOrganisation(facilityOrganisationDto)

        facilityOrganisationService.save(facilityOrganisation)
    }
}
