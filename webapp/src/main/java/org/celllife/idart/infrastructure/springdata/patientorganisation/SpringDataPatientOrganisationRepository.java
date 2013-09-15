package org.celllife.idart.infrastructure.springdata.patientorganisation;

import org.celllife.idart.common.OrganisationId;
import org.celllife.idart.common.PatientId;
import org.celllife.idart.relationship.patientorganisation.PatientOrganisation;
import org.celllife.idart.relationship.patientorganisation.PatientOrganisationRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h07
 */
public interface SpringDataPatientOrganisationRepository extends PatientOrganisationRepository,
        CrudRepository<PatientOrganisation, Long> {

    @Query("select patientOrganisation " +
            "   from PatientOrganisation patientOrganisation " +
            "where patientOrganisation.patient = :patient " +
            "   and patientOrganisation.organisation = :organisation " +
            "   and patientOrganisation.relationship = :relationship " +
            "   and patientOrganisation.valid.fromDate <= :validDate" +
            "   and (patientOrganisation.valid.thruDate is null or patientOrganisation.valid.thruDate > :validDate)")
    PatientOrganisation findByPatientOrganisationRelationshipValid(@Param("patient") PatientId patient,
                                                                             @Param("organisation") OrganisationId organisation,
                                                                             @Param("relationship") PatientOrganisation.Relationship relationship,
                                                                             @Param("validDate") Date validDate);

    @Query("select patientOrganisation " +
            "   from PatientOrganisation patientOrganisation " +
            "where patientOrganisation.patient = :patient " +
            "   and patientOrganisation.relationship = :relationship " +
            "   and patientOrganisation.valid.fromDate <= :validDate" +
            "   and (patientOrganisation.valid.thruDate is null or patientOrganisation.valid.thruDate > :validDate)")
    Iterable<PatientOrganisation> findByPatientRelationshipValid(@Param("patient") PatientId patient,
                                                                           @Param("relationship") PatientOrganisation.Relationship relationship,
                                                                           @Param("validDate") Date validDate);

    @Query("select patientOrganisation " +
            "   from PatientOrganisation patientOrganisation " +
            "where patientOrganisation.organisation = :organisation " +
            "   and patientOrganisation.relationship = :relationship " +
            "   and patientOrganisation.valid.fromDate <= :validDate" +
            "   and (patientOrganisation.valid.thruDate is null or patientOrganisation.valid.thruDate > :validDate)")
    Iterable<PatientOrganisation> findByOrganisationRelationshipValid(@Param("organisation") OrganisationId organisation,
                                                                           @Param("relationship") PatientOrganisation.Relationship relationship,
                                                                           @Param("validDate") Date validDate);


}
