package org.celllife.idart.application.part

import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h33
 */
@Service class FinishedGoodApplicationServiceImpl implements FinishedGoodApplicationService {

    @Autowired FinishedGoodService finishedGoodService

    @Autowired PartApplicationService partApplicationService

    FinishedGood save(FinishedGood finishedGood) {

        finishedGood.billOfMaterials.each { billOfMaterial ->
            billOfMaterial.part = partApplicationService.findByIdentifiers(billOfMaterial.part.identifiers)
        }

        finishedGoodService.save(finishedGood)
    }

}
