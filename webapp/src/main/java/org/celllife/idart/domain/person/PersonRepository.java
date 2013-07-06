package org.celllife.idart.domain.person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 12h47
 */
@RestResource(path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
