package org.celllife.idart.domain.prescription

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 19h16
 */
interface PrescriptionValidator {

    void validate(Prescription prescription) throws PrescriptionValidationException

}