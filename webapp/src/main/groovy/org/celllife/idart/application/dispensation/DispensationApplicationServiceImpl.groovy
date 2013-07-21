package org.celllife.idart.application.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Service
@Mixin(DispensationApplicationServiceMixin)
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationApplicationServiceImpl implements DispensationApplicationService, DispensationResourceService {

    @Autowired DispensationService dispensationService

    Dispensation save(Dispensation dispensation) {
        dispensationService.save(dispensation)
    }

    Dispensation findByIdentifier(String identifier) {
        dispensationService.findByIdentifier(identifier)
    }

    Iterable<Dispensation> findAll() {
        dispensationService.findAll()
    }

}