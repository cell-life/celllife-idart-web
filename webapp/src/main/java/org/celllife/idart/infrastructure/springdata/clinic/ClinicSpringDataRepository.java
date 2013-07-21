package org.celllife.idart.domain.clinic;

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
public interface ClinicSpringDataRepository extends CrudRepository<Clinic, Long> {

    Clinic findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<Clinic> findByIdentifier(String identifierValue);
}
