package org.celllife.idart.application.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.common.DispensationIdentifier
import org.celllife.idart.domain.dispensation.DispensationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensationApplicationServiceImpl implements DispensationApplicationService {

    @Autowired DispensationService dispensationService

    Dispensation save(Dispensation dispensation) throws DispensationValidationException {
        dispensationService.save(dispensation)
    }

    Dispensation findByDispensationIdentifier(DispensationIdentifier dispensationIdentifier) throws DispensationNotFoundException{
        dispensationService.findByDispensationIdentifier(dispensationIdentifier)
    }

}