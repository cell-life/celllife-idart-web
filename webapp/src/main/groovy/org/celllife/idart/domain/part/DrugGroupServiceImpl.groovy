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
@Service class DrugGroupServiceImpl implements DrugGroupService {

    @Autowired DrugGroupRepository drugGroupRepository

    @Override
    DrugGroup save(DrugGroup drugGroup) {

        DrugGroup existingDrugGroup = findByIdentifiers(drugGroup.identifiers)
        if (existingDrugGroup == null) {
            existingDrugGroup = drugGroup.class.newInstance()
        }

        existingDrugGroup.merge(drugGroup)

        drugGroupRepository.save(existingDrugGroup)
    }


    @Override
    Iterable<DrugGroup> findAll() {
        drugGroupRepository.findAll()
    }

    @Override
    DrugGroup findByIdentifier(String identifier) {
        null
    }

    @Override
    DrugGroup findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            DrugGroup drugGroup = drugGroupRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (drugGroup != null) {
                return drugGroup
            }
        }

        null
    }
}