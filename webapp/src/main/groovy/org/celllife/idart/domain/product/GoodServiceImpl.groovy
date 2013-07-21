package org.celllife.idart.domain.product

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
@Service class GoodServiceImpl implements GoodService {

    @Autowired GoodRepository goodRepository

    @Override
    Good save(Good good) {

        Good existingGood = findByIdentifiers(good.identifiers)
        if (existingGood == null) {
            existingGood = good.class.newInstance()
        }

        existingGood.merge(good)

        goodRepository.save(existingGood)
    }


    @Override
    Iterable<Good> findAll() {
        goodRepository.findAll()
    }

    @Override
    Good findByIdentifier(String identifier) {
        null
    }

    @Override
    Good findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Good good = goodRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (good != null) {
                return good
            }
        }

        null
    }
}