package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.SAVED
import static org.celllife.idart.domain.dispensation.DispensationEvent.newDispensationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DispensationServiceImpl implements DispensationService {

    @Inject DispensationRepository dispensationRepository

    @Inject DispensationValidator dispensationValidator

    @Inject DispensationEventPublisher dispensationEventPublisher
    
    @Inject DispensationSequence dispensationSequence
    
    @Override
    Boolean exists(DispensationId dispensationId) {
        dispensationRepository.exists(dispensationId)
    }
    
    @Override
    Dispensation save(Dispensation dispensation) {

        def existingDispensation = null

        if (dispensation.id != null) {
            existingDispensation = dispensationRepository.findOne(dispensation.id)
        } else {
            dispensation.id = dispensationSequence.nextValue()
        }

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
