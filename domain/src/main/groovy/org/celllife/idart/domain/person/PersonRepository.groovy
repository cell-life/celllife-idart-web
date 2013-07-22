package org.celllife.idart.domain.person;

import javax.annotation.Generated;

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonRepository {

    Person save(Person person)

    public <S extends Person> Iterable<S> save(Iterable<S> persons)

    Person findOne(Long pk)

    Iterable<Person> findAll()

    Person findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Person> findByIdentifier(String identifierValue)
}
