package org.celllife.idart.application.prescription

/**
 * Exception that indicates that it was not possible to delete a prescription
 */
class PrescriptionNotDeletedException extends RuntimeException {

    PrescriptionNotDeletedException(String message) {
        super(message)
    }
	
	PrescriptionNotDeletedException(String message, Exception e) {
		super(message, e)
	}
}
