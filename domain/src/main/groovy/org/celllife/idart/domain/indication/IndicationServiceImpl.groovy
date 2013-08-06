package org.celllife.idart.domain.indication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class IndicationServiceImpl implements IndicationService {

    @Autowired IndicationRepository indicationRepository

    @Autowired IndicationValidator indicationValidator

    @Override
    Indication save(Indication indication) throws IndicationValidationException {

        indicationValidator.validate(indication)

        indicationRepository.save(indication)
    }

    @Override
    Indication findByCode(IndicationCode code) throws IndicationNotFoundException {

        def indication = indicationRepository.findOne(code)

        if (indication == null) {
            throw new IndicationNotFoundException("Could not find Indication with Code [${ code}]")
        }

        indication
    }
}