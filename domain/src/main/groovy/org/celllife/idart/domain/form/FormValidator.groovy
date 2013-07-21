package org.celllife.idart.domain.form

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FormValidator {

    void validate(Form form) throws FormValidationException

}