package org.celllife.idart.application.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.common.FormCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FormApplicationService {

    Form save(Form form) throws FormValidationException

    Form findByFormCode(FormCode formCode) throws FormNotFoundException

}
