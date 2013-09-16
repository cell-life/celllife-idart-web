package org.celllife.idart.application.form

import org.celllife.idart.application.form.dto.FormDto
import org.celllife.idart.application.form.dto.FormDtoAssembler
import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.domain.form.FormService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.FormCode.formCode
import static org.celllife.idart.common.IdentifiableType.FORM
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormApplicationServiceImpl implements FormApplicationService {

    @Inject FormService formService   

    @Inject FormDtoAssembler formDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(FormCode formCode) {
        formService.exists(formCode)
    }

    @Override
    FormCode save(FormDto formDto) {

        def identifiable = identifiableService.resolveIdentifiable(FORM, formDto.identifiers)

        def formCode = formCode(identifiable.getIdentifierValue(IDART))

        def form = formDtoAssembler.toForm(formDto)
        form.id = formCode

        formService.save(form)

        form.id
    }

    @Override
    FormDto findByFormCode(FormCode formCode) {
        def identifier = newIdentifier(IDART, formCode.value)
        findByIdentifier(identifier)
    }

    @Override
    FormDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(FORM, [identifier] as Set)

        if (identifiable == null) {
            throw new FormNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def formCode = formCode(identifiable.getIdentifierValue(IDART))

        def form = formService.findByFormCode(formCode)

        def formDto = formDtoAssembler.toFormDto(form)
        formDto.identifiers = identifiable.identifiers

        formDto
    }

    @Override
    FormCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(FORM, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        formCode(idartIdentifierValue)
    }
}
