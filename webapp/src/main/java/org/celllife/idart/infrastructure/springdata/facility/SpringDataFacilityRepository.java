package org.celllife.idart.infrastructure.springdata.facility;

import org.celllife.idart.common.FacilityId;
import org.celllife.idart.domain.facility.Facility;
import org.celllife.idart.domain.facility.FacilityRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataFacilityRepository extends FacilityRepository,
        PagingAndSortingRepository<Facility, FacilityId> {

}
