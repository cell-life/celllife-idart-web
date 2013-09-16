package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.facility.FacilityEvent.EventType.SAVED
import static org.celllife.idart.domain.facility.FacilityEvent.newFacilityEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FacilityServiceImpl implements FacilityService {

    @Inject FacilityRepository facilityRepository

    @Inject FacilityValidator facilityValidator

    @Inject FacilityEventPublisher facilityEventPublisher

    @Override
    Boolean exists(FacilityId facilityId) {
        facilityRepository.exists(facilityId)
    }

    @Override
    Facility save(Facility facility) {

        def existingFacility = facilityRepository.findOne(facility.id)

        if (existingFacility == null) {
            existingFacility = facility
        } else {
            existingFacility.merge(facility)
        }

        facilityValidator.validate(existingFacility)

        facilityEventPublisher.publish(newFacilityEvent(existingFacility, SAVED))

        facilityRepository.save(existingFacility)
    }

    @Override
    Facility findByFacilityId(FacilityId facilityId) {

        def facility = facilityRepository.findOne(facilityId)

        if (facility == null) {
            throw new FacilityNotFoundException("Could not find Facility with id [${ facilityId}]")
        }

        facility
    }
}
