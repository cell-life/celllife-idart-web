package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.product.Good
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
@Service class FinishedGoodServiceImpl implements FinishedGoodService {

    @Autowired FinishedGoodRepository finishedGoodRepository

    @Override
    FinishedGood save(FinishedGood finishedGood) {

        FinishedGood existingFinishedGood = findByIdentifiers(finishedGood.identifiers)
        if (existingFinishedGood == null) {
            existingFinishedGood = new FinishedGood()
        }

        existingFinishedGood.merge(finishedGood)

        finishedGoodRepository.save(existingFinishedGood)
    }

    @Override
    FinishedGood findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {
            def finishedGood = finishedGoodRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (finishedGood != null) {
                return finishedGood
            }
        }

        null
    }

}
