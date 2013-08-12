package org.celllife.idart.infrastructure.springdata.systemfacility;

import org.celllife.idart.common.FacilityIdentifier;
import org.celllife.idart.common.SystemIdentifier;
import org.celllife.idart.domain.systemfacility.SystemFacility;
import org.celllife.idart.domain.systemfacility.SystemFacilityRelationship;
import org.celllife.idart.domain.systemfacility.SystemFacilityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-12
 * Time: 16h01
 */
public interface SpringDataSystemFacilityRepository extends SystemFacilityRepository,
        PagingAndSortingRepository<SystemFacility, Long> {

    @Query("select systemFacility from SystemFacility systemFacility " +
            "where systemFacility.fromSystem = :fromSystem " +
            "and systemFacility.toFacility = :toFacility " +
            "and systemFacility.relationship = :relationship")
    SystemFacility findBySystemAndFacilityAndRelationship(@Param("fromSystem") SystemIdentifier fromSystem,
                                                          @Param("toFacility") FacilityIdentifier toFacility,
                                                          @Param("relationship") SystemFacilityRelationship relationship);
}
