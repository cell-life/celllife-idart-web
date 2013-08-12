package org.celllife.idart.domain.indication

import org.celllife.idart.common.IndicationCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class IndicationServiceImpl implements IndicationService {

    @Autowired IndicationRepository indicationRepository

    @Autowired IndicationValidator indicationValidator

    @Autowired IndicationEventPublisher indicationEventPublisher

    @Override
    Indication save(Indication indication) throws IndicationValidationException {

        indicationValidator.validate(indication)

        indicationEventPublisher.indicationSaved(indication)

        indicationRepository.save(indication)
    }

    @Override
    Indication findByIndicationCode(IndicationCode indicationCode) throws IndicationNotFoundException {

        def indication = indicationRepository.findOne(indicationCode)

        if (indication == null) {
            throw new IndicationNotFoundException("Could not find Indication with Indication Code [${ indicationCode}]")
        }

        indication
    }
}