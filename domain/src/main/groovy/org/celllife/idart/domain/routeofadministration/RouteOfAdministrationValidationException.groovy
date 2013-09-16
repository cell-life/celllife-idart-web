package org.celllife.idart.domain.routeofadministration

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationValidationException extends RuntimeException {

    Set<ConstraintViolation<RouteOfAdministration>> constraintViolations

    RouteOfAdministrationValidationException(Set<ConstraintViolation<RouteOfAdministration>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
