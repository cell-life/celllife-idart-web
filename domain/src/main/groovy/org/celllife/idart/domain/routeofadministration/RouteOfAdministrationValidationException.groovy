package org.celllife.idart.domain.routeofadministration

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationValidationException extends RuntimeException {

    Set<ConstraintViolation<RouteOfAdministration>> constraintViolations

    RouteOfAdministrationValidationException(Set<ConstraintViolation<RouteOfAdministration>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
