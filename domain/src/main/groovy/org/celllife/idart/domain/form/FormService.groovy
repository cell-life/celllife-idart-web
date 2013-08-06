package org.celllife.idart.domain.form

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormService {

    Form save(Form form) throws FormValidationException

    Form findByCode(FormCode code) throws FormNotFoundException

}