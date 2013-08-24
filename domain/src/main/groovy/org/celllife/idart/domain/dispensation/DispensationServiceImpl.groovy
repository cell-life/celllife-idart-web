package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.dispensation.DispensationEvent.EventType.SAVED
import static org.celllife.idart.domain.dispensation.DispensationEvent.newDispensationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensationServiceImpl implements DispensationService {

    @Autowired DispensationRepository dispensationRepository

    @Autowired DispensationValidator dispensationValidator

    @Autowired DispensationEventPublisher dispensationEventPublisher

    @Override
    Dispensation save(Dispensation dispensation) throws DispensationValidationException {

        dispensationValidator.validate(dispensation)

        dispensationEventPublisher.publish(newDispensationEvent(dispensation, SAVED))

        dispensationRepository.save(dispensation)
    }

    @Override
    Dispensation findByDispensationId(DispensationId dispensationId) throws DispensationNotFoundException {

        def dispensation = dispensationRepository.findOne(dispensationId)

        if (dispensation == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with Dispensation Id [${ dispensationId}]")
        }

        dispensation
    }
}
