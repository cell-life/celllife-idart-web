package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        dispensationEventPublisher.dispensationSaved(dispensation)

        dispensationRepository.save(dispensation)
    }

    @Override
    Dispensation findByDispensationIdentifier(DispensationIdentifier dispensationIdentifier) throws DispensationNotFoundException {

        def dispensation = dispensationRepository.findOne(dispensationIdentifier)

        if (dispensation == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with Dispensation Identifier [${ dispensationIdentifier}]")
        }

        dispensation
    }
}