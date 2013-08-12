package org.celllife.idart.infrastructure.jsr303.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303RouteOfAdministrationValidator implements RouteOfAdministrationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException {

        Set<ConstraintViolation<RouteOfAdministration>> constraintViolations = validatorFactory.validator.validate(routeOfAdministration)

        if (!constraintViolations.empty) {
            throw new RouteOfAdministrationValidationException(constraintViolations)
        }
    }
}
