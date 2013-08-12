package org.celllife.idart.infrastructure.springdata.person;

import org.celllife.idart.common.PartyIdentifier;
import org.celllife.idart.domain.person.Person;
import org.celllife.idart.domain.person.PersonRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPersonRepository extends PagingAndSortingRepository<Person, PartyIdentifier>, PersonRepository {

}