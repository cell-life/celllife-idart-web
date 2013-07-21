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
@Service class DrugServiceImpl implements DrugService {

    @Autowired DrugRepository drugRepository

    @Override
    Drug save(Drug drug) {

        Drug existingDrug = findByIdentifiers(drug.identifiers)
        if (existingDrug == null) {
            existingDrug = drug.class.newInstance()
        }

        existingDrug.merge(drug)

        drugRepository.save(existingDrug)
    }


    @Override
    Iterable<Drug> findAll() {
        drugRepository.findAll()
    }

    @Override
    Drug findByIdentifier(String identifier) {
        null
    }

    @Override
    Drug findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Drug drug = drugRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (drug != null) {
                return drug
            }
        }

        null
    }
}