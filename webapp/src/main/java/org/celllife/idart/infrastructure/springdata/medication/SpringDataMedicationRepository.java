package org.celllife.idart.infrastructure.springdata.medication;

import org.celllife.idart.domain.medication.Medication;
import org.celllife.idart.domain.medication.MedicationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataMedicationRepository extends PagingAndSortingRepository<Medication, Long>, MedicationRepository {

    @Query("select medication " +
            "from Medication medication " +
            "join medication.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Medication findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct medication " +
            "from Medication medication " +
            "join medication.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Medication> findByIdentifier(@Param("identifierValue") String identifierValue);

}
