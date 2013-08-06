package org.celllife.idart.domain.person;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonRepository {

    Person save(Person person)

    public <S extends Person> Iterable<S> save(Iterable<S> people)

    Person findOne(Long pk)

    Iterable<Person> findAll()

    Person findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Person> findByIdentifier(String identifierValue)
}
