package org.celllife.idart.infrastructure.springdata.organisation;

import org.celllife.idart.domain.organisation.LegalOrganisation;
import org.celllife.idart.domain.organisation.LegalOrganisationRepository;

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
@RestResource(path = "legalOrganisations")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataLegalOrganisationRepository extends PagingAndSortingRepository<LegalOrganisation, Long>, LegalOrganisationRepository{

    @Query("select legalOrganisation " +
            "from LegalOrganisation legalOrganisation " +
            "join legalOrganisation.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    LegalOrganisation findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct legalOrganisation " +
            "from LegalOrganisation legalOrganisation " +
            "join legalOrganisation.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<LegalOrganisation> findByIdentifier(@Param("identifierValue") String identifierValue);
}