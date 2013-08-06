package org.celllife.idart.application.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.domain.form.FormCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FormApplicationService {

    Form save(Form form) throws FormValidationException

    Form findByCode(FormCode code) throws FormNotFoundException

}