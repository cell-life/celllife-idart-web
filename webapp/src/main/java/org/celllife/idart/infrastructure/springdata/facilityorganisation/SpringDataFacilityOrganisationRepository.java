package org.celllife.idart.infrastructure.springdata.facilityorganisation;

import org.celllife.idart.common.FacilityId;
import org.celllife.idart.common.OrganisationId;
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation;
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h07
 */
public interface SpringDataFacilityOrganisationRepository extends FacilityOrganisationRepository,
        CrudRepository<FacilityOrganisation, Long> {

    @Query("select facilityOrganisation " +
            "   from FacilityOrganisation facilityOrganisation " +
            "where facilityOrganisation.facility = :facility " +
            "   and facilityOrganisation.organisation = :organisation " +
            "   and facilityOrganisation.relationship = :relationship " +
            "   and facilityOrganisation.valid.fromDate <= :validDate" +
            "   and (facilityOrganisation.valid.thruDate is null or facilityOrganisation.valid.thruDate > :validDate)")
    FacilityOrganisation findByFacilityOrganisationRelationshipValid(@Param("facility") FacilityId facility,
                                                                     @Param("organisation") OrganisationId organisation,
                                                                     @Param("relationship") FacilityOrganisation.Relationship relationship,
                                                                     @Param("validDate") Date validDate);

    @Query("select facilityOrganisation " +
            "   from FacilityOrganisation facilityOrganisation " +
            "where facilityOrganisation.facility = :facility " +
            "   and facilityOrganisation.relationship = :relationship " +
            "   and facilityOrganisation.valid.fromDate <= :validDate" +
            "   and (facilityOrganisation.valid.thruDate is null or facilityOrganisation.valid.thruDate > :validDate)")
    Iterable<FacilityOrganisation> findByFacilityRelationshipValid(@Param("facility") FacilityId facility,
                                                                   @Param("relationship") FacilityOrganisation.Relationship relationship,
                                                                   @Param("validDate") Date validDate);


}
