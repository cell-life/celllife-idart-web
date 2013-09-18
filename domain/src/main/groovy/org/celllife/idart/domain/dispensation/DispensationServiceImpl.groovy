package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.SAVED
import static org.celllife.idart.domain.dispensation.DispensationEvent.newDispensationEvent

/**
 */
@Named class DispensationServiceImpl implements DispensationService {

    @Inject DispensationRepository dispensationRepository

    @Inject DispensationValidator dispensationValidator

    @Inject DispensationEventPublisher dispensationEventPublisher

    @Override
    Boolean exists(DispensationId dispensationId) {
        dispensationRepository.exists(dispensationId)
    }

    @Override
    Dispensation save(Dispensation dispensation) {

        def existingDispensation = dispensationRepository.findOne(dispensation.id)

        if (existingDispensation == null) {
            existingDispensation = dispensation
        } else {
            existingDispensation.merge(dispensation)
        }

        dispensationValidator.validate(existingDispensation)

        dispensationEventPublisher.publish(newDispensationEvent(existingDispensation, SAVED))

        dispensationRepository.save(existingDispensation)
    }

    @Override
    Dispensation findByDispensationId(DispensationId dispensationId) {

        def dispensation = dispensationRepository.findOne(dispensationId)

        if (dispensation == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with id [${ dispensationId}]")
        }

        dispensation
    }
}
