package org.celllife.idart.application.encounter;

import org.celllife.idart.domain.encounter.Encounter;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterResourceService {

    Encounter save(Encounter encounter);

    Encounter findByIdentifier(String identifier);

    Iterable<Encounter> findAll();

}