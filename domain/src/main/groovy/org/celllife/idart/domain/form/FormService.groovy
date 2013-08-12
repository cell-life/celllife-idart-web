package org.celllife.idart.domain.form

import org.celllife.idart.common.FormCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormService {

    Form save(Form form) throws FormValidationException

    Form findByFormCode(FormCode formCode) throws FormNotFoundException

}