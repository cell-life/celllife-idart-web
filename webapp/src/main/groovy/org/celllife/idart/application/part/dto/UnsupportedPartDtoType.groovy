package org.celllife.idart.application.part.dto

import org.celllife.idart.application.part.dto.PartDto

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedPartDtoType extends RuntimeException {

    UnsupportedPartDtoType(Class<PartDto> partDtoClass) {
        super(partDtoClass.toString())
    }
}
