package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.practitioner.PractitionerEvent.EventType.SAVED
import static org.celllife.idart.domain.practitioner.PractitionerEvent.newPractitionerEvent

/**
 */
@Named class PractitionerServiceImpl implements PractitionerService {

    @Inject PractitionerRepository practitionerRepository

    @Inject PractitionerValidator practitionerValidator

    @Inject PractitionerEventPublisher practitionerEventPublisher

    @Override
    Boolean exists(PractitionerId practitionerId) {
        practitionerRepository.exists(practitionerId)
    }

    @Override
    Practitioner save(Practitioner practitioner) {

        def existingPractitioner = practitionerRepository.findOne(practitioner.id)

        if (existingPractitioner == null) {
            existingPractitioner = practitioner
        } else {
            existingPractitioner.merge(practitioner)
        }

        practitionerValidator.validate(existingPractitioner)

        practitionerEventPublisher.publish(newPractitionerEvent(existingPractitioner, SAVED))

        practitionerRepository.save(existingPractitioner)
    }

    @Override
    Practitioner findByPractitionerId(PractitionerId practitionerId) {

        def practitioner = practitionerRepository.findOne(practitionerId)

        if (practitioner == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with id [${ practitionerId}]")
        }

        practitioner
    }

    @Override
    PersonId findPersonByPractitionerId(PractitionerId practitionerId) {
        practitionerRepository.findPersonByPractitionerId(practitionerId)
    }
}
