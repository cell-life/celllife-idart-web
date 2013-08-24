package org.celllife.idart.application.encounter

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterValidationException
import org.celllife.idart.domain.encounter.EncounterNotFoundException
import org.celllife.idart.common.EncounterId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface EncounterApplicationService {

    Encounter save(Encounter encounter) throws EncounterValidationException

    Encounter findByEncounterId(EncounterId encounterId) throws EncounterNotFoundException

}
