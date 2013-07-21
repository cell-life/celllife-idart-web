package org.celllife.idart.domain.practitioner;

import javax.annotation.Generated;

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerRepository {

    Practitioner save(Practitioner practitioner)

    public <S extends Practitioner> Iterable<S> save(Iterable<S> practitioners)

    Practitioner findOne(Long pk)

    Iterable<Practitioner> findAll()

    Practitioner findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Practitioner> findByIdentifier(String identifierValue)
}
