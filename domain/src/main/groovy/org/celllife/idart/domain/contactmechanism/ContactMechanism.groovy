package org.celllife.idart.domain.contactmechanism

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 23h19
 */
abstract class ContactMechanism implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

}
