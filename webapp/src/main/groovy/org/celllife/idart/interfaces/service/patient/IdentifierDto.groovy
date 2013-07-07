package org.celllife.idart.interfaces.service.patient

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 11h00
 */
class IdentifierDto {

    String system

    @NotNull
    String value

}
