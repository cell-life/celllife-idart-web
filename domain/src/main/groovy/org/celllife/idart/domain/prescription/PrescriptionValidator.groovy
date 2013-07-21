package org.celllife.idart.domain.prescription

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescriptionValidator {

    void validate(Prescription prescription) throws PrescriptionValidationException

}