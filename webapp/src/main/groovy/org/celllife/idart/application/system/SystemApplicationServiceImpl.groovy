package org.celllife.idart.application.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.application.system.dto.SystemDtoAssembler
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.domain.system.SystemService

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.IdentifiableType.SYSTEM
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SystemApplicationServiceImpl implements SystemApplicationService {

    @Inject SystemService systemService   

    @Inject SystemDtoAssembler systemDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SystemId systemId) {
        systemService.exists(systemId)
    }

    @Override
    SystemId save(SystemDto systemDto) {

        def identifiable = identifiableService.resolveIdentifiable(SYSTEM, systemDto.identifiers)

        def systemId = systemId(identifiable.getIdentifierValue(IDART_WEB))

        def system = systemDtoAssembler.toSystem(systemDto)
        system.id = systemId

        systemService.save(system)

        system.id
    }

    @Override
    SystemDto findBySystemId(SystemId systemId) {
        def identifier = newIdentifier(IDART_WEB, systemId.value)
        findByIdentifier(identifier)
    }

    @Override
    SystemDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(SYSTEM, [identifier] as Set)

        if (identifiable == null) {
            throw new SystemNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def systemId = systemId(identifiable.getIdentifierValue(IDART_WEB))

        def system = systemService.findBySystemId(systemId)

        def systemDto = systemDtoAssembler.toSystemDto(system)
        systemDto.identifiers = identifiable.identifiers

        systemDto
    }

    @Override
    SystemId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(SYSTEM, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        systemId(idartIdentifierValue)
    }
}
