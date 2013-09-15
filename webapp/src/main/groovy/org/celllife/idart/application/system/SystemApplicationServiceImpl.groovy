package org.celllife.idart.application.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.domain.system.SystemService

import static org.celllife.idart.application.system.dto.SystemDtoAssembler.toSystem
import static org.celllife.idart.application.system.dto.SystemDtoAssembler.toSystemDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.domain.identifiable.IdentifiableType.SYSTEM
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SystemApplicationServiceImpl implements SystemApplicationService {

    @Inject SystemService systemService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SystemId systemId) {
        systemService.exists(systemId)
    }

    SystemId save(SystemDto systemDto) {

        def system = toSystem(systemDto)

        def identifiable = identifiableService.findByIdentifiers(SYSTEM, systemDto.identifiers)
        if (identifiable == null) {

            system = systemService.save(system)

            identifiable = new Identifiable(type: SYSTEM, identifiers: systemDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, system.id.value))
            identifiableService.save(identifiable)

        } else {

            system.id = systemId(identifiable.getIdentifier(IDART).value)
            systemService.save(system)

        }

        system.id
    }

    @Override
    SystemDto findBySystemId(SystemId systemId) {
        def identifier = newIdentifier(IDART, systemId.value)
        findByIdentifier(identifier)
    }

    @Override
    SystemDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(SYSTEM, [identifier] as Set)

        if (identifiable == null) {
            throw new SystemNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def systemId = systemId(identifiable.getIdentifier(IDART).value)

        def system = systemService.findBySystemId(systemId)

        def systemDto = toSystemDto(system)
        systemDto.identifiers = identifiable.identifiers

        systemDto
    }
}
