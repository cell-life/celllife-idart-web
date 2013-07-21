package org.celllife.idart.application.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.CompoundService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(CompoundApplicationServiceMixin)
class CompoundApplicationServiceImpl implements CompoundApplicationService, CompoundResourceService {

    @Autowired CompoundService compoundService

    Compound save(Compound compound) {
        compoundService.save(compound)
    }

    Compound findByIdentifier(String identifier) {
        compoundService.findByIdentifier(identifier)
    }

    Iterable<Compound> findAll() {
        compoundService.findAll()
    }

}