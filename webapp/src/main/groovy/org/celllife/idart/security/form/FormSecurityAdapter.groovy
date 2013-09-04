package org.celllife.idart.security.form

import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.form.Form
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

    Form save(Principal principal, Form form) {
        formApplicationService.save(form)
    }

    Form findByFormCode(Principal principal, FormCode formCode) {
        formApplicationService.findByFormCode(formCode)
    }

}
