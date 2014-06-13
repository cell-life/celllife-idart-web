package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.PrescriptionId;

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.SAVED
import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.DELETED
import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.UPDATED
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

        def saveDispensation = dispensation

        def existingDispensation = dispensationRepository.findOne(dispensation.id)

        if (existingDispensation != null) {
            existingDispensation.merge(dispensation)
            saveDispensation = existingDispensation
        }

        dispensationValidator.validate(saveDispensation)

        if (existingDispensation == null) {
            dispensationEventPublisher.publish(newDispensationEvent(saveDispensation, SAVED))
        } else {
            dispensationEventPublisher.publish(newDispensationEvent(saveDispensation, UPDATED))
        }

        dispensationRepository.save(saveDispensation)
    }

    @Override
    Dispensation findByDispensationId(DispensationId dispensationId) {

        def dispensation = dispensationRepository.findOne(dispensationId)

        if (dispensation == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with id [${ dispensationId}]")
        }

        dispensation
    }
    
    @Override
    Dispensation deleteByDispensationId(DispensationId dispensationId) {
        Dispensation d = findByDispensationId(dispensationId)
        dispensationEventPublisher.publish(newDispensationEvent(d, DELETED))
        return dispensationRepository.delete(dispensationId)
    }
}