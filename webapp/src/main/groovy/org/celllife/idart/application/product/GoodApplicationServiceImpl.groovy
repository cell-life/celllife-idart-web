package org.celllife.idart.application.product

import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.product.GoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h57
 */
@Service class GoodApplicationServiceImpl implements GoodApplicationService, GoodResourceService {

    @Autowired FinishedGoodService finishedGoodService

    @Autowired GoodService goodService

    Good save(Good good) {

        good.finishedGood = finishedGoodService.save(good.finishedGood)

        goodService.save(good)
    }

    @Override
    Good findByIdentifier(String identifier) {
        goodService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Good> findAll() {
        goodService.findAll()
    }
}
