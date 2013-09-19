package org.celllife.idart.application.encounter.dto

import org.celllife.idart.common.Duration
import org.celllife.idart.common.Identifier

/**
 */
class EncounterDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Participants
     */
    Set<ParticipantDto> participants = [] as Set

    /**
     * Patient
     */
    Set<Identifier> patient = [] as Set

    /**
     * Location
     */
    Set<Identifier> facility = [] as Set

    /**
     * Started at
     */
    Date startedAt

    /**
     * Duration
     */
    Duration duration

}
