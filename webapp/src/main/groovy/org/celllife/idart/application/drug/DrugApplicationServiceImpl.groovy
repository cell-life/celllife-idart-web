package org.celllife.idart.application.drug

import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.drug.DrugValidationException
import org.celllife.idart.domain.drug.DrugNotFoundException
import org.celllife.idart.common.PartIdentifier
import org.celllife.idart.domain.drug.DrugService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DrugApplicationServiceImpl implements DrugApplicationService {

    @Autowired DrugService drugService

    Drug save(Drug drug) throws DrugValidationException {
        drugService.save(drug)
    }

    Drug findByPartIdentifier(PartIdentifier partIdentifier) throws DrugNotFoundException{
        drugService.findByPartIdentifier(partIdentifier)
    }

}