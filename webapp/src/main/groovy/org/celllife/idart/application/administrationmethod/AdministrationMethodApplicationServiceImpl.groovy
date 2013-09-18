package org.celllife.idart.application.administrationmethod

import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDto
import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDtoAssembler
import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.administrationmethod.AdministrationMethodNotFoundException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodService

import static org.celllife.idart.common.AdministrationMethodCode.administrationMethodCode
import static org.celllife.idart.common.IdentifiableType.ADMINISTRATION_METHOD
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.SystemId.IDART_WEB

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodApplicationServiceImpl implements AdministrationMethodApplicationService {

    @Inject AdministrationMethodService administrationMethodService   

    @Inject AdministrationMethodDtoAssembler administrationMethodDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(AdministrationMethodCode administrationMethodCode) {
        administrationMethodService.exists(administrationMethodCode)
    }

    @Override
    AdministrationMethodCode save(AdministrationMethodDto administrationMethodDto) {

        def identifiable = identifiableService.resolveIdentifiable(ADMINISTRATION_METHOD, administrationMethodDto.identifiers)
        administrationMethodDto.identifiers = identifiable.identifiers

        def administrationMethodCode = administrationMethodCode(identifiable.getIdentifierValue(IDART_WEB))

        def administrationMethod = administrationMethodDtoAssembler.toAdministrationMethod(administrationMethodDto)
        administrationMethod.id = administrationMethodCode

        administrationMethodService.save(administrationMethod)

        administrationMethod.id
    }

    @Override
    AdministrationMethodDto findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) {
        def identifier = newIdentifier(IDART_WEB, administrationMethodCode.value)
        findByIdentifier(identifier)
    }

    @Override
    AdministrationMethodDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(ADMINISTRATION_METHOD, [identifier] as Set)

        if (identifiable == null) {
            throw new AdministrationMethodNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def administrationMethodCode = administrationMethodCode(identifiable.getIdentifierValue(IDART_WEB))

        def administrationMethod = administrationMethodService.findByAdministrationMethodCode(administrationMethodCode)

        def administrationMethodDto = administrationMethodDtoAssembler.toAdministrationMethodDto(administrationMethod)
        administrationMethodDto.identifiers = identifiable.identifiers

        administrationMethodDto
    }

    @Override
    AdministrationMethodCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(ADMINISTRATION_METHOD, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        administrationMethodCode(idartIdentifierValue)
    }
}
