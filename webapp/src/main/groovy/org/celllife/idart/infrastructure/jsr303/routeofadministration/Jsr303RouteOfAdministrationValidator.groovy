package org.celllife.idart.infrastructure.jsr303.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class Jsr303RouteOfAdministrationValidator implements RouteOfAdministrationValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(RouteOfAdministration routeOfAdministration) {

        Set<ConstraintViolation<RouteOfAdministration>> constraintViolations = validatorFactory.validator.validate(routeOfAdministration)

        if (!constraintViolations.empty) {
            throw new RouteOfAdministrationValidationException(constraintViolations)
        }
    }
}
