package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId


/**
 */
public interface EncounterRepository {

    boolean exists(EncounterId encounterId)

    Encounter save(Encounter encounter)

    Encounter findOne(EncounterId encounterId)

}
