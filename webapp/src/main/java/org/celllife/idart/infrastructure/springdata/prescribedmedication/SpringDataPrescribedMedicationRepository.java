package org.celllife.idart.infrastructure.springdata.prescribedmedication;

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication;
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPrescribedMedicationRepository extends PagingAndSortingRepository<PrescribedMedication, Long>, PrescribedMedicationRepository {

    @Query("select prescribedMedication " +
            "from PrescribedMedication prescribedMedication " +
            "join prescribedMedication.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    PrescribedMedication findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct prescribedMedication " +
            "from PrescribedMedication prescribedMedication " +
            "join prescribedMedication.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<PrescribedMedication> findByIdentifier(@Param("identifierValue") String identifierValue);

}
