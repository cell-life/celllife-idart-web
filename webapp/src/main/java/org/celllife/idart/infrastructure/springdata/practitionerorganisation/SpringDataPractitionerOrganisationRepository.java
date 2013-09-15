package org.celllife.idart.infrastructure.springdata.practitionerorganisation;

import org.celllife.idart.common.OrganisationId;
import org.celllife.idart.common.PractitionerId;
import org.celllife.idart.relationship.practitionerorganisation.PractitionerOrganisation;
import org.celllife.idart.relationship.practitionerorganisation.PractitionerOrganisationRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h07
 */
public interface SpringDataPractitionerOrganisationRepository extends PractitionerOrganisationRepository,
        CrudRepository<PractitionerOrganisation, Long> {

    @Query("select practitionerOrganisation " +
            "   from PractitionerOrganisation practitionerOrganisation " +
            "where practitionerOrganisation.practitioner = :practitioner " +
            "   and practitionerOrganisation.organisation = :organisation " +
            "   and practitionerOrganisation.relationship = :relationship " +
            "   and practitionerOrganisation.valid.fromDate <= :validDate" +
            "   and (practitionerOrganisation.valid.thruDate is null or practitionerOrganisation.valid.thruDate > :validDate)")
    PractitionerOrganisation findByPractitionerOrganisationRelationshipValid(@Param("practitioner") PractitionerId practitioner,
                                                                             @Param("organisation") OrganisationId organisation,
                                                                             @Param("relationship") PractitionerOrganisation.Relationship relationship,
                                                                             @Param("validDate") Date validDate);

    @Query("select practitionerOrganisation " +
            "   from PractitionerOrganisation practitionerOrganisation " +
            "where practitionerOrganisation.practitioner = :practitioner " +
            "   and practitionerOrganisation.relationship = :relationship " +
            "   and practitionerOrganisation.valid.fromDate <= :validDate" +
            "   and (practitionerOrganisation.valid.thruDate is null or practitionerOrganisation.valid.thruDate > :validDate)")
    Iterable<PractitionerOrganisation> findByPractitionerRelationshipValid(@Param("practitioner") PractitionerId practitioner,
                                                                           @Param("relationship") PractitionerOrganisation.Relationship relationship,
                                                                           @Param("validDate") Date validDate);

    @Query("select practitionerOrganisation " +
            "   from PractitionerOrganisation practitionerOrganisation " +
            "where practitionerOrganisation.organisation = :organisation " +
            "   and practitionerOrganisation.relationship = :relationship " +
            "   and practitionerOrganisation.valid.fromDate <= :validDate" +
            "   and (practitionerOrganisation.valid.thruDate is null or practitionerOrganisation.valid.thruDate > :validDate)")
    Iterable<PractitionerOrganisation> findByOrganisationRelationshipValid(@Param("organisation") OrganisationId organisation,
                                                                           @Param("relationship") PractitionerOrganisation.Relationship relationship,
                                                                           @Param("validDate") Date validDate);


}
