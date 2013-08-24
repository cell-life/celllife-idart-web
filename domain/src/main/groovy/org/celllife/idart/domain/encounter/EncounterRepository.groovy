package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterRepository {

    Encounter save(Encounter encounter)

    Encounter findOne(EncounterId encounterId)

}
