package org.celllife.idart.domain.user


/**
 */
class DuplicateUsernameException extends RuntimeException {

    DuplicateUsernameException(String message) {
        super(message)
    }
}
