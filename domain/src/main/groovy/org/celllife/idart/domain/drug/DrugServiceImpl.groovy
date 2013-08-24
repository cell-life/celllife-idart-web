package org.celllife.idart.domain.drug

import org.celllife.idart.common.PartId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.drug.DrugEvent.EventType.SAVED
import static org.celllife.idart.domain.drug.DrugEvent.newDrugEvent

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

        drugEventPublisher.publish(newDrugEvent(drug, SAVED))

        drugRepository.save(drug)
    }

    @Override
    Drug findByPartId(PartId partId) throws DrugNotFoundException {

        def drug = drugRepository.findOne(partId)

        if (drug == null) {
            throw new DrugNotFoundException("Could not find Drug with Part Id [${ partId}]")
        }

        drug
    }
}
