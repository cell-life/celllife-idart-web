package org.celllife.idart.application.part.dto

import org.celllife.idart.domain.part.Part

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedPartType extends RuntimeException {

    UnsupportedPartType(Class<Part> partClass) {
        super(partClass.toString())
    }
}
