package org.celllife.idart.domain.encounter;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EncounterRepository {

    Encounter save(Encounter encounter)

    public <S extends Encounter> Iterable<S> save(Iterable<S> encounters)

    Encounter findOne(Long pk)

    Iterable<Encounter> findAll()

    Encounter findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Encounter> findByIdentifier(String identifierValue)
}
