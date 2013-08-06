package org.celllife.idart.application.person;

import org.celllife.idart.domain.person.Person;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonResourceService {

    Person save(Person person);

    Person findByIdentifier(String identifier);

    Iterable<Person> findAll();

}