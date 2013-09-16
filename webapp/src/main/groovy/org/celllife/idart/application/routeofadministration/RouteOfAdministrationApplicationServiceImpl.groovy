package org.celllife.idart.application.routeofadministration

import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDto
import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDtoAssembler
import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.RouteOfAdministrationCode.routeOfAdministrationCode
import static org.celllife.idart.common.IdentifiableType.ROUTE_OF_ADMINISTRATION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationApplicationServiceImpl implements RouteOfAdministrationApplicationService {

    @Inject RouteOfAdministrationService routeOfAdministrationService   

    @Inject RouteOfAdministrationDtoAssembler routeOfAdministrationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationService.exists(routeOfAdministrationCode)
    }

    @Override
    RouteOfAdministrationCode save(RouteOfAdministrationDto routeOfAdministrationDto) {

        def identifiable = identifiableService.resolveIdentifiable(ROUTE_OF_ADMINISTRATION, routeOfAdministrationDto.identifiers)

        def routeOfAdministrationCode = routeOfAdministrationCode(identifiable.getIdentifierValue(IDART))

        def routeOfAdministration = routeOfAdministrationDtoAssembler.toRouteOfAdministration(routeOfAdministrationDto)
        routeOfAdministration.id = routeOfAdministrationCode

        routeOfAdministrationService.save(routeOfAdministration)

        routeOfAdministration.id
    }

    @Override
    RouteOfAdministrationDto findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) {
        def identifier = newIdentifier(IDART, routeOfAdministrationCode.value)
        findByIdentifier(identifier)
    }

    @Override
    RouteOfAdministrationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(ROUTE_OF_ADMINISTRATION, [identifier] as Set)

        if (identifiable == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def routeOfAdministrationCode = routeOfAdministrationCode(identifiable.getIdentifierValue(IDART))

        def routeOfAdministration = routeOfAdministrationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)

        def routeOfAdministrationDto = routeOfAdministrationDtoAssembler.toRouteOfAdministrationDto(routeOfAdministration)
        routeOfAdministrationDto.identifiers = identifiable.identifiers

        routeOfAdministrationDto
    }

    @Override
    RouteOfAdministrationCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(ROUTE_OF_ADMINISTRATION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        routeOfAdministrationCode(idartIdentifierValue)
    }
}
