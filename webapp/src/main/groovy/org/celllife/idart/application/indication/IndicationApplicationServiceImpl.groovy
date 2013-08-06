package org.celllife.idart.application.indication

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.domain.indication.IndicationCode
import org.celllife.idart.domain.indication.IndicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class IndicationApplicationServiceImpl implements IndicationApplicationService {

    @Autowired IndicationService indicationService

    Indication save(Indication indication) throws IndicationValidationException {
        indicationService.save(indication)
    }

    Indication findByCode(IndicationCode code) throws IndicationNotFoundException{
        indicationService.findByCode(code)
    }

}