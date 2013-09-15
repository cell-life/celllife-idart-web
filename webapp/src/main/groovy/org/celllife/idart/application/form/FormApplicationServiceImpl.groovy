package org.celllife.idart.application.form

import org.celllife.idart.application.form.dto.FormDto
import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.domain.form.FormService

import static org.celllife.idart.application.form.dto.FormDtoAssembler.toForm
import static org.celllife.idart.application.form.dto.FormDtoAssembler.toFormDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.FormCode.formCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.FORM
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormApplicationServiceImpl implements FormApplicationService {

    @Inject FormService formService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(FormCode formCode) {
        formService.exists(formCode)
    }

    FormCode save(FormDto formDto) {

        def form = toForm(formDto)

        def identifiable = identifiableService.findByIdentifiers(FORM, formDto.identifiers)
        if (identifiable == null) {

            form = formService.save(form)

            identifiable = new Identifiable(type: FORM, identifiers: formDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, form.id.value))
            identifiableService.save(identifiable)

        } else {

            form.id = formCode(identifiable.getIdentifier(IDART).value)
            formService.save(form)

        }

        form.id
    }

    @Override
    FormDto findByFormCode(FormCode formCode) {
        def identifier = newIdentifier(IDART, formCode.value)
        findByIdentifier(identifier)
    }

    @Override
    FormDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(FORM, [identifier] as Set)

        if (identifiable == null) {
            throw new FormNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def formCode = formCode(identifiable.getIdentifier(IDART).value)

        def form = formService.findByFormCode(formCode)

        def formDto = toFormDto(form)
        formDto.identifiers = identifiable.identifiers

        formDto
    }
}
