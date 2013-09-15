package org.celllife.idart.domain.form

import org.celllife.idart.common.FormCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormRepository {

    boolean exists(FormCode formCode)

    Form save(Form form)

    Form findOne(FormCode formCode)

}
