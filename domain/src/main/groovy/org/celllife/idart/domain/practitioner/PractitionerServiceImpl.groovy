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

    @Override
    Practitioner save(Practitioner practitioner) {

        practitionerValidator.validate(practitioner)

        practitionerEventPublisher.publish(newPractitionerEvent(practitioner, SAVED))

        practitionerRepository.save(practitioner)
    }

    @Override
    Practitioner findByPractitionerId(PractitionerId practitionerId) {

        def practitioner = practitionerRepository.findOne(practitionerId)

        if (practitioner == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with Practitioner Id [${ practitionerId}]")
        }

        practitioner
    }
}
