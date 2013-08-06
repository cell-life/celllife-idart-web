package org.celllife.idart.domain.form

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormRepository {

    Form save(Form form)

    Form findOne(FormCode code)

}
