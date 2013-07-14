package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
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
    void save(FinishedGood finishedGood) {

        FinishedGood existingFinishedGood = findOneByIdentifiers(finishedGood.identifiers)
        if (existingFinishedGood == null) {
            existingFinishedGood = new FinishedGood()
        }

        merge(finishedGood, existingFinishedGood)

        finishedGoodRepository.save(existingFinishedGood)
    }

    static merge(FinishedGood source, FinishedGood target) {
        target.mergeIdentifiers(source)
        target.unitOfMeasure = source.unitOfMeasure
        target.form = source.form
        target.mergeClassifications(source)
        target.billOfMaterials = source.billOfMaterials
    }

    FinishedGood findOneByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def finishedGood = finishedGoodRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (finishedGood != null) {
                return finishedGood
            }
        }

        null
    }

}
