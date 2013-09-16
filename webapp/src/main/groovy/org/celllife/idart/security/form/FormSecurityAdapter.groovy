package org.celllife.idart.security.form

import org.celllife.idart.application.form.dto.FormDto
import org.celllife.idart.common.FormCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.form.FormApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormSecurityAdapter {

    @Inject FormApplicationService formApplicationService

    FormCode save(Principal principal, formDto) {
        formApplicationService.save(formDto)
    }

    FormDto findByFormCode(Principal principal, FormCode formCode) {
        formApplicationService.findByFormCode(formCode)
    }

    FormDto findByIdentifier(Principal principal, Identifier identifier) {
        formApplicationService.findByIdentifier(identifier)
    }

}
