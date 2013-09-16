package org.celllife.idart.domain.encounter

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.common.PractitionerId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-16
 * Time: 18h27
 */
@EqualsAndHashCode
class Participant implements Serializable {

    /**
     * Participant Type
     */
    ParticipantType type

    /**
     * Practitioner
     */
    PractitionerId practitioner

}


