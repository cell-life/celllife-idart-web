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
    Set<ParticipantDto> participants

    /**
     * Patient
     */
    Set<Identifier> patient

    /**
     * Location
     */
    Set<Identifier> facility

    /**
     * Started at
     */
    Date startedAt

    /**
     * Duration
     */
    Duration duration

}
