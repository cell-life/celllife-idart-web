package org.celllife.idart.domain.part;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h19
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FinishedGoodSpringDataRepository extends CrudRepository<FinishedGood, Long> {

    FinishedGood findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<FinishedGood> findByIdentifier(String identifierValue);
}
