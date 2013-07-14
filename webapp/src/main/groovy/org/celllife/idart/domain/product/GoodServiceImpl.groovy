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
    void save(Good good) {

        Good existingGood = findOneByIdentifiers(good.identifiers)
        if (existingGood == null) {
            existingGood = new Good()
        }

        merge(good, existingGood)

        goodRepository.save(existingGood)
    }

    static merge(Good source, Good target) {
        target.mergeIdentifiers(source)
        target.finishedGood = source.finishedGood
    }

    Good findOneByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def good = goodRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (good != null) {
                return good
            }
        }

        null
    }

}
