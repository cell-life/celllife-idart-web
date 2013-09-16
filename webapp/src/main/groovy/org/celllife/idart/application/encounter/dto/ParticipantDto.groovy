package org.celllife.idart.application.encounter.dto

import org.celllife.idart.domain.encounter.ParticipantType
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-16
 * Time: 18h38
 */
class ParticipantDto implements Serializable {

    /**
     * Participant Type
     */
    ParticipantType type

    /**
     * Practitioner
     */
    Set<Identifier> practitioner
}
