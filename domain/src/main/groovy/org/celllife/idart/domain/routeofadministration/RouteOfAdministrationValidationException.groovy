package org.celllife.idart.domain.routeofadministration

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationValidationException extends RuntimeException {

    Set<ConstraintViolation<RouteOfAdministration>> constraintViolations

    RouteOfAdministrationValidationException(Set<ConstraintViolation<RouteOfAdministration>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
