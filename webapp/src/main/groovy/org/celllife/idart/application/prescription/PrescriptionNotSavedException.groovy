package org.celllife.idart.application.prescription

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-28
 * Time: 13h50
 */
class PrescriptionNotSavedException extends RuntimeException {

    PrescriptionNotSavedException(String message) {
        super(message)
    }
	
	PrescriptionNotSavedException(String message, Exception e) {
		super(message, e)
	}
}
