package org.celllife.idart.application.encounter

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.common.Identifier


/**
 */
interface EncounterApplicationService {

    Boolean exists(EncounterId encounterId)

    EncounterId save(EncounterDto encounterDto)

    EncounterDto findByEncounterId(EncounterId encounterId)

    EncounterDto findByIdentifier(Identifier identifier)

    EncounterId findByIdentifiers(Set<Identifier> identifiers)

}
