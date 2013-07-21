package org.celllife.idart.application.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h48
 */
@Service
@Mixin(FinishedGoodApplicationServiceMixin)
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FinishedGoodApplicationServiceImpl implements FinishedGoodApplicationService, FinishedGoodResourceService {

    @Autowired FinishedGoodService finishedGoodService

    FinishedGood save(FinishedGood finishedGood) {
        finishedGoodService.save(finishedGood)
    }

    FinishedGood findByIdentifier(String identifier) {
        finishedGoodService.findByIdentifier(identifier)
    }

    Iterable<FinishedGood> findAll() {
        finishedGoodService.findAll()
    }

}