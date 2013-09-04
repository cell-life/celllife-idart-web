package org.celllife.idart.application.patient

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-28
 * Time: 20h23
 */
class PatientWithoutAPersonException extends RuntimeException{

    PatientWithoutAPersonException(String message) {
        super(message)
    }
}
