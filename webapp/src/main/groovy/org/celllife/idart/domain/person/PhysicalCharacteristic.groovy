package org.celllife.idart.domain.person

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 14h06
 */
abstract class PhysicalCharacteristic {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    @NotNull
    Date fromDate

    Date thruDate

}
