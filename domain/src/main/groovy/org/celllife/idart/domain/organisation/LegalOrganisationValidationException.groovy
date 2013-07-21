package org.celllife.idart.domain.organisation

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LegalOrganisationValidationException extends RuntimeException {

    Set<ConstraintViolation<LegalOrganisation>> constraintViolations

    LegalOrganisationValidationException(Set<ConstraintViolation<LegalOrganisation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
