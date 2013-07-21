package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FinishedGoodServiceImpl implements FinishedGoodService {

    @Autowired FinishedGoodRepository finishedGoodRepository

    @Override
    FinishedGood save(FinishedGood finishedGood) {

        FinishedGood existingFinishedGood = findByIdentifiers(finishedGood.identifiers)
        if (existingFinishedGood == null) {
            existingFinishedGood = finishedGood.class.newInstance()
        }

        existingFinishedGood.merge(finishedGood)

        finishedGoodRepository.save(existingFinishedGood)
    }


    @Override
    Iterable<FinishedGood> findAll() {
        finishedGoodRepository.findAll()
    }

    @Override
    FinishedGood findByIdentifier(String identifier) {
        null
    }

    @Override
    FinishedGood findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            FinishedGood finishedGood = finishedGoodRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (finishedGood != null) {
                return finishedGood
            }
        }

        null
    }
}