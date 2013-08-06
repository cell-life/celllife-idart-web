package org.celllife.idart.infrastructure.validation.drug

import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.drug.DrugValidationException
import org.celllife.idart.domain.drug.DrugValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateDrugValidator implements DrugValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Drug drug) throws DrugValidationException {

        Set<ConstraintViolation<Drug>> constraintViolations = validatorFactory.validator.validate(drug)

        if (!constraintViolations.empty) {
            throw new DrugValidationException(constraintViolations)
        }
    }
}
