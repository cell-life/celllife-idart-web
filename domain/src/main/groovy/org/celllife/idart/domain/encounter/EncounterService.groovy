package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterService {

    Encounter save(Encounter encounter)

    Encounter findByEncounterId(EncounterId encounterId)

}
