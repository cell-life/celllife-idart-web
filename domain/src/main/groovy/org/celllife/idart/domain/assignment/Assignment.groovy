package org.celllife.idart.domain.assignment

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 21h50
 */
class Assignment implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Practitioner practitioner

    Clinic clinic

}
