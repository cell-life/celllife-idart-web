package org.celllife.idart.domain.exception

import javax.validation.ConstraintViolation

/**
 * Parent class for Validation Exceptions. It processes the specified violations so that they are displayed in the stacktrace.
 */
class ValidationException extends RuntimeException {

    Set<ConstraintViolation<? extends Serializable>> constraintViolations

    ValidationException(Set<ConstraintViolation<? extends Serializable>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }

    @Override
    public String getMessage() {
        StringBuffer sb = new StringBuffer()
        sb.append("Validation Error: ")
        if (constraintViolations != null) {
            for (ConstraintViolation sv : constraintViolations) {
                sb.append("\n")
                sb.append(sv.getPropertyPath())
                sb.append(" ")
                sb.append(sv.getMessage())
                sb.append(" (value is ")
                sb.append(sv.getInvalidValue())
                sb.append(") ")
                sb.append(sv.getRootBean())
            }
        } else {
            sb.append("unknown. " + super.getMessage())
        }
        return sb.toString()
    }
}