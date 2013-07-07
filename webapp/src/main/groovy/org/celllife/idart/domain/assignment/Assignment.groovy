package org.celllife.idart.domain.assignment

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
    Long pk

    Practitioner practitioner

    Clinic clinic

}
