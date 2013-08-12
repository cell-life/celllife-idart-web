package org.celllife.idart.domain.drug

import org.celllife.idart.common.PartIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DrugServiceImpl implements DrugService {

    @Autowired DrugRepository drugRepository

    @Autowired DrugValidator drugValidator

    @Autowired DrugEventPublisher drugEventPublisher

    @Override
    Drug save(Drug drug) throws DrugValidationException {

        drugValidator.validate(drug)

        drugEventPublisher.drugSaved(drug)

        drugRepository.save(drug)
    }

    @Override
    Drug findByPartIdentifier(PartIdentifier partIdentifier) throws DrugNotFoundException {

        def drug = drugRepository.findOne(partIdentifier)

        if (drug == null) {
            throw new DrugNotFoundException("Could not find Drug with Part Identifier [${ partIdentifier}]")
        }

        drug
    }
}