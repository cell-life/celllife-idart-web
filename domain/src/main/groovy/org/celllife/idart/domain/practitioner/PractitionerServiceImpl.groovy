package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.practitioner.PractitionerEvent.EventType.SAVED
import static org.celllife.idart.domain.practitioner.PractitionerEvent.newPractitionerEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PractitionerServiceImpl implements PractitionerService {

    @Inject PractitionerRepository practitionerRepository

    @Inject PractitionerValidator practitionerValidator

    @Inject PractitionerEventPublisher practitionerEventPublisher
    
    @Inject PractitionerSequence practitionerSequence
    
    @Override
    Boolean exists(PractitionerId practitionerId) {
        practitionerRepository.exists(practitionerId)
    }
    
    @Override
    Practitioner save(Practitioner practitioner) {

        def existingPractitioner = null

        if (practitioner.id != null) {
            existingPractitioner = practitionerRepository.findOne(practitioner.id)
        } else {
            practitioner.id = practitionerSequence.nextValue()
        }

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
}
