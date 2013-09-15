package org.celllife.idart.application.routeofadministration

import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDto
import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService

import static org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDtoAssembler.toRouteOfAdministration
import static org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDtoAssembler.toRouteOfAdministrationDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.RouteOfAdministrationCode.routeOfAdministrationCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.ROUTE_OF_ADMINISTRATION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationApplicationServiceImpl implements RouteOfAdministrationApplicationService {

    @Inject RouteOfAdministrationService routeOfAdministrationService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationService.exists(routeOfAdministrationCode)
    }

    RouteOfAdministrationCode save(RouteOfAdministrationDto routeOfAdministrationDto) {

        def routeOfAdministration = toRouteOfAdministration(routeOfAdministrationDto)

        def identifiable = identifiableService.findByIdentifiers(ROUTE_OF_ADMINISTRATION, routeOfAdministrationDto.identifiers)
        if (identifiable == null) {

            routeOfAdministration = routeOfAdministrationService.save(routeOfAdministration)

            identifiable = new Identifiable(type: ROUTE_OF_ADMINISTRATION, identifiers: routeOfAdministrationDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, routeOfAdministration.id.value))
            identifiableService.save(identifiable)

        } else {

            routeOfAdministration.id = routeOfAdministrationCode(identifiable.getIdentifier(IDART).value)
            routeOfAdministrationService.save(routeOfAdministration)

        }

        routeOfAdministration.id
    }

    @Override
    RouteOfAdministrationDto findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) {
        def identifier = newIdentifier(IDART, routeOfAdministrationCode.value)
        findByIdentifier(identifier)
    }

    @Override
    RouteOfAdministrationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ROUTE_OF_ADMINISTRATION, [identifier] as Set)

        if (identifiable == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def routeOfAdministrationCode = routeOfAdministrationCode(identifiable.getIdentifier(IDART).value)

        def routeOfAdministration = routeOfAdministrationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)

        def routeOfAdministrationDto = toRouteOfAdministrationDto(routeOfAdministration)
        routeOfAdministrationDto.identifiers = identifiable.identifiers

        routeOfAdministrationDto
    }
}
