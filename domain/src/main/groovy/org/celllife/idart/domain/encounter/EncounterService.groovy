package org.celllife.idart.domain.encounter

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterService {

    Encounter save(Encounter encounter)

    Iterable<Encounter> findAll()

    Encounter findByIdentifier(String identifier)

    Encounter findByIdentifiers(Iterable<Identifier> identifiers)

}