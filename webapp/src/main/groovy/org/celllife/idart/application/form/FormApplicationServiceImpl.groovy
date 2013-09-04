package org.celllife.idart.application.form

import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormApplicationServiceImpl implements FormApplicationService {

    @Inject FormService formService

    Form save(Form form) {
        formService.save(form)
    }

    Form findByFormCode(FormCode formCode) {
        formService.findByFormCode(formCode)
    }

}
