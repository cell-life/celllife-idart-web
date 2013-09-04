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

    @Override
    Dispensation save(Dispensation dispensation) {

        dispensationValidator.validate(dispensation)

        dispensationEventPublisher.publish(newDispensationEvent(dispensation, SAVED))

        dispensationRepository.save(dispensation)
    }

    @Override
    Dispensation findByDispensationId(DispensationId dispensationId) {

        def dispensation = dispensationRepository.findOne(dispensationId)

        if (dispensation == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with Dispensation Id [${ dispensationId}]")
        }

        dispensation
    }
}
