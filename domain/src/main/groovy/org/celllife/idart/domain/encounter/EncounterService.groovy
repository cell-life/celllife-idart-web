package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId


/**
 */
public interface EncounterService {

    Boolean exists(EncounterId encounterId)

    Encounter save(Encounter encounter)

    Encounter findByEncounterId(EncounterId encounterId)

}
