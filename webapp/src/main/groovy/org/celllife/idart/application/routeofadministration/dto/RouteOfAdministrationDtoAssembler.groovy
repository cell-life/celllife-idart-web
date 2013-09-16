package org.celllife.idart.application.routeofadministration.dto

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationDtoAssembler {

    RouteOfAdministration toRouteOfAdministration(RouteOfAdministrationDto routeOfAdministrationDto) {

        def routeOfAdministration = new RouteOfAdministration()
        routeOfAdministration.with {

        }

        routeOfAdministration
    }

    RouteOfAdministrationDto toRouteOfAdministrationDto(RouteOfAdministration routeOfAdministration) {

        def routeOfAdministrationDto = new RouteOfAdministrationDto()
        routeOfAdministrationDto.with {

        }

        routeOfAdministrationDto
    }
}
