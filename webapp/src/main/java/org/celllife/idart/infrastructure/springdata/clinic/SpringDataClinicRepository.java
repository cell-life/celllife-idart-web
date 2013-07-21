package org.celllife.idart.infrastructure.springdata.clinic;

import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.clinic.ClinicRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@RestResource(path = "clinics")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataClinicRepository extends PagingAndSortingRepository<Clinic, Long>, ClinicRepository{

    @Query("select clinic " +
            "from Clinic clinic " +
            "join clinic.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Clinic findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct clinic " +
            "from Clinic clinic " +
            "join clinic.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Clinic> findByIdentifier(@Param("identifierValue") String identifierValue);
}