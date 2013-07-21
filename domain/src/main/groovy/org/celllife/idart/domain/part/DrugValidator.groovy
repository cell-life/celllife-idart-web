package org.celllife.idart.domain.part

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DrugValidator {

    void validate(Drug drug) throws DrugValidationException

}