package org.celllife.idart.application.routeofadministration

import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDto
import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface RouteOfAdministrationApplicationService {

    Boolean exists(RouteOfAdministrationCode routeOfAdministrationCode)

    RouteOfAdministrationCode save(RouteOfAdministrationDto routeOfAdministrationDto)

    RouteOfAdministrationDto findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode)

    RouteOfAdministrationDto findByIdentifier(Identifier identifier)

}
