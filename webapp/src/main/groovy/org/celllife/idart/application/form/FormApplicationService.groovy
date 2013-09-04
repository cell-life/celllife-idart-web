package org.celllife.idart.application.form

import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.form.Form

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FormApplicationService {

    Form save(Form form)

    Form findByFormCode(FormCode formCode)

}
