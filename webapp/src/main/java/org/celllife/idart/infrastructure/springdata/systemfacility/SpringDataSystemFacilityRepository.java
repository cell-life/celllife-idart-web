package org.celllife.idart.infrastructure.springdata.systemfacility;

import org.celllife.idart.common.FacilityId;
import org.celllife.idart.common.SystemId;
import org.celllife.idart.relationship.systemfacility.SystemFacility;
import org.celllife.idart.relationship.systemfacility.SystemFacilityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h07
 */
public interface SpringDataSystemFacilityRepository extends SystemFacilityRepository,
        CrudRepository<SystemFacility, Long> {

    @Query("select systemFacility " +
            "   from SystemFacility systemFacility " +
            "where systemFacility.system = :system " +
            "   and systemFacility.facility = :facility " +
            "   and systemFacility.relationship = :relationship " +
            "   and systemFacility.valid.fromDate <= :validDate" +
            "   and (systemFacility.valid.thruDate is null or systemFacility.valid.thruDate > :validDate)")
    SystemFacility findBySystemFacilityRelationshipValid(@Param("system") SystemId system,
                                                         @Param("facility") FacilityId facility,
                                                         @Param("relationship") SystemFacility.Relationship relationship,
                                                         @Param("validDate") Date validDate);

    @Query("select systemFacility " +
            "   from SystemFacility systemFacility " +
            "where systemFacility.system = :system " +
            "   and systemFacility.relationship = :relationship " +
            "   and systemFacility.valid.fromDate <= :validDate" +
            "   and (systemFacility.valid.thruDate is null or systemFacility.valid.thruDate > :validDate)")
    SystemFacility findBySystemRelationshipValid(@Param("system") SystemId system,
                                                 @Param("relationship") SystemFacility.Relationship relationship,
                                                 @Param("validDate") Date validDate);

    @Query("select systemFacility " +
            "   from SystemFacility systemFacility " +
            "where systemFacility.facility = :facility " +
            "   and systemFacility.relationship = :relationship " +
            "   and systemFacility.valid.fromDate <= :validDate" +
            "   and (systemFacility.valid.thruDate is null or systemFacility.valid.thruDate > :validDate)")
    SystemFacility findByFacilityRelationshipValid(@Param("facility") FacilityId facility,
                                                   @Param("relationship") SystemFacility.Relationship relationship,
                                                   @Param("validDate") Date validDate);


}
