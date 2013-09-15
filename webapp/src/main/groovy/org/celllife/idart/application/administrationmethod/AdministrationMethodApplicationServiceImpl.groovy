package org.celllife.idart.application.administrationmethod

import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDto
import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.administrationmethod.AdministrationMethodNotFoundException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodService

import static org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDtoAssembler.toAdministrationMethod
import static org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDtoAssembler.toAdministrationMethodDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.AdministrationMethodCode.administrationMethodCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.ADMINISTRATION_METHOD
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodApplicationServiceImpl implements AdministrationMethodApplicationService {

    @Inject AdministrationMethodService administrationMethodService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(AdministrationMethodCode administrationMethodCode) {
        administrationMethodService.exists(administrationMethodCode)
    }

    AdministrationMethodCode save(AdministrationMethodDto administrationMethodDto) {

        def administrationMethod = toAdministrationMethod(administrationMethodDto)

        def identifiable = identifiableService.findByIdentifiers(ADMINISTRATION_METHOD, administrationMethodDto.identifiers)
        if (identifiable == null) {

            administrationMethod = administrationMethodService.save(administrationMethod)

            identifiable = new Identifiable(type: ADMINISTRATION_METHOD, identifiers: administrationMethodDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, administrationMethod.id.value))
            identifiableService.save(identifiable)

        } else {

            administrationMethod.id = administrationMethodCode(identifiable.getIdentifier(IDART).value)
            administrationMethodService.save(administrationMethod)

        }

        administrationMethod.id
    }

    @Override
    AdministrationMethodDto findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) {
        def identifier = newIdentifier(IDART, administrationMethodCode.value)
        findByIdentifier(identifier)
    }

    @Override
    AdministrationMethodDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ADMINISTRATION_METHOD, [identifier] as Set)

        if (identifiable == null) {
            throw new AdministrationMethodNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def administrationMethodCode = administrationMethodCode(identifiable.getIdentifier(IDART).value)

        def administrationMethod = administrationMethodService.findByAdministrationMethodCode(administrationMethodCode)

        def administrationMethodDto = toAdministrationMethodDto(administrationMethod)
        administrationMethodDto.identifiers = identifiable.identifiers

        administrationMethodDto
    }
}
