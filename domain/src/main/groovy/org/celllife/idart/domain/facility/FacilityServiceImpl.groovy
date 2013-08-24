package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.facility.FacilityEvent.EventType.SAVED
import static org.celllife.idart.domain.facility.FacilityEvent.newFacilityEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FacilityServiceImpl implements FacilityService {

    @Autowired FacilityRepository facilityRepository

    @Autowired FacilityValidator facilityValidator

    @Autowired FacilityEventPublisher facilityEventPublisher

    @Override
    Facility save(Facility facility) throws FacilityValidationException {

        facilityValidator.validate(facility)

        facilityEventPublisher.publish(newFacilityEvent(facility, SAVED))

        facilityRepository.save(facility)
    }

    @Override
    Facility findByFacilityId(FacilityId facilityId) throws FacilityNotFoundException {

        def facility = facilityRepository.findOne(facilityId)

        if (facility == null) {
            throw new FacilityNotFoundException("Could not find Facility with Facility Id [${ facilityId}]")
        }

        facility
    }
}
