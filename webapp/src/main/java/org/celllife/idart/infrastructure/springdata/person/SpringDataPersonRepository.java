package org.celllife.idart.infrastructure.springdata.person;

import org.celllife.idart.common.PersonId;
import org.celllife.idart.domain.person.Person;
import org.celllife.idart.domain.person.PersonRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataPersonRepository extends PersonRepository,
        PagingAndSortingRepository<Person, PersonId> {

}
