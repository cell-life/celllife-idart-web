package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterService {

    Encounter save(Encounter encounter) throws EncounterValidationException

    Encounter findByEncounterIdentifier(EncounterIdentifier encounterIdentifier) throws EncounterNotFoundException

}