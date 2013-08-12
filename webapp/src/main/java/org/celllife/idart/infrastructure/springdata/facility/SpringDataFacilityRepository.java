package org.celllife.idart.infrastructure.springdata.facility;

import org.celllife.idart.common.FacilityIdentifier;
import org.celllife.idart.domain.facility.Facility;
import org.celllife.idart.domain.facility.FacilityRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataFacilityRepository extends FacilityRepository,
        PagingAndSortingRepository<Facility, FacilityIdentifier> {

}