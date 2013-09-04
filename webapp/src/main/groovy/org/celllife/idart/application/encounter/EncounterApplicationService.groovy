package org.celllife.idart.application.encounter

import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.encounter.Encounter

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface EncounterApplicationService {

    Encounter save(Encounter encounter)

    Encounter findByEncounterId(EncounterId encounterId)

}
