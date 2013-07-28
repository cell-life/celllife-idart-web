package org.celllife.idart.infrastructure.springdata.clinicmedication;

import org.celllife.idart.domain.clinicmedication.ClinicMedication;
import org.celllife.idart.domain.clinicmedication.ClinicMedicationRepository;
import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.medication.Medication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.Date;

import javax.annotation.Generated;

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@RestResource(exported = false)
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataClinicMedicationRepository
        extends PagingAndSortingRepository<ClinicMedication, Long>, ClinicMedicationRepository {

    @Query("select clinicMedication " +
            "from ClinicMedication clinicMedication " +
            "where clinicMedication.clinic = :clinic " +
            "and clinicMedication.medication = :medication " +
            "and clinicMedication.fromDate <= :dateActive " +
            "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    ClinicMedication findByClinicAndMedicationAndDateActive(
                @Param("clinic") Clinic clinic,
                @Param("medication") Medication medication,
                @Param("dateActive") Date dateActive);

    @Query("select count(*) " +
            "from ClinicMedication clinicMedication " +
            "where clinicMedication.clinic = :clinic " +
            "and clinicMedication.medication = :medication " +
            "and clinicMedication.fromDate <= :dateActive " +
            "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    Long countByClinicAndMedicationAndDateActive(
                @Param("clinic") Clinic clinic,
                @Param("medication") Medication medication,
                @Param("dateActive") Date dateActive);

    @Query("select clinicMedication " +
            "from ClinicMedication clinicMedication " +
            "where clinicMedication.clinic = :clinic " +
            "and clinicMedication.fromDate <= :dateActive " +
            "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    Iterable<ClinicMedication> findByClinicAndDateActive(
                @Param("clinic") Clinic clinic,
                @Param("dateActive") Date dateActive);

    @Query("select clinicMedication " +
            "from ClinicMedication clinicMedication " +
            "where clinicMedication.clinic.pk = :clinicIdentifier " +
            "and clinicMedication.fromDate <= :dateActive " +
            "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    Iterable<ClinicMedication> findByClinicIdentifierAndDateActive(
                @Param("clinicIdentifier") String clinicIdentifier,
                @Param("dateActive") Date dateActive);


    @Query("select clinicMedication " +
                "from ClinicMedication clinicMedication " +
                "join clinicMedication.medication.identifiers medicationIdentifier " +
                "where clinicMedication.clinic.pk = :clinicIdentifier " +
                "and medicationIdentifier.value = :medicationIdentifier " +
                "and clinicMedication.fromDate <= :dateActive " +
                "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    Iterable<ClinicMedication> findByClinicIdentifierAndMedicationIdentifierAndDateActive(
                @Param("clinicIdentifier") String clinicIdentifier,
                @Param("medicationIdentifier") String medicationIdentifier,
                @Param("dateActive") Date dateActive);

    @Query("select clinicMedication " +
                "from ClinicMedication clinicMedication " +
                "where clinicMedication.clinic.pk = :clinicIdentifier " +
                "and clinicMedication.medication.pk = :medicationIdentifier " +
                "and clinicMedication.fromDate <= :dateActive " +
                "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    ClinicMedication findOneByClinicIdentifierAndMedicationIdentifierAndDateActive(
                @Param("clinicIdentifier") String clinicIdentifier,
                @Param("medicationIdentifier") String medicationIdentifier,
                @Param("dateActive") Date dateActive);

    @Query("select clinicMedication " +
            "from ClinicMedication clinicMedication " +
            "where clinicMedication.medication = :medication " +
            "and clinicMedication.fromDate <= :dateActive " +
            "and ((clinicMedication.thruDate is not null and clinicMedication.thruDate > :dateActive) or clinicMedication.thruDate is null)")
    Iterable<ClinicMedication> findByMedicationAndDateActive(
                @Param("medication") Medication medication,
                @Param("dateActive") Date dateActive);

}
