package org.celllife.idart.domain.organisation;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 21h34
 */
@RestResource(path = "legalOrganisations")
public interface LegalOrganisationSpringDataRepository extends LegalOrganisationRepository,  PagingAndSortingRepository<LegalOrganisation, Long> {
}
