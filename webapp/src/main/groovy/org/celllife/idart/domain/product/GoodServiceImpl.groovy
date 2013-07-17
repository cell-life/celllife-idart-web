package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
@Service class GoodServiceImpl implements GoodService {

    @Autowired GoodRepository goodRepository

    @Override
    Good save(Good good) {

        Good existingGood = findByIdentifiers(good.identifiers)
        if (existingGood == null) {
            existingGood = new Good()
        }

        merge(good, existingGood)

        goodRepository.save(existingGood)
    }

    @Override
    Good findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def good = goodRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (good != null) {
                return good
            }
        }

        null
    }

    static merge(Good source, Good target) {
        target.mergeIdentifiers(source)
        target.finishedGood = source.finishedGood
    }

}
