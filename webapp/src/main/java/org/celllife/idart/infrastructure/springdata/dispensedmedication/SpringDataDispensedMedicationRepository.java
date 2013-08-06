package org.celllife.idart.infrastructure.springdata.dispensedmedication;

import org.celllife.idart.domain.dispensedmedication.DispensedMedication;
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDispensedMedicationRepository extends PagingAndSortingRepository<DispensedMedication, Long>, DispensedMedicationRepository {

    @Query("select dispensedMedication " +
            "from DispensedMedication dispensedMedication " +
            "join dispensedMedication.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    DispensedMedication findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct dispensedMedication " +
            "from DispensedMedication dispensedMedication " +
            "join dispensedMedication.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<DispensedMedication> findByIdentifier(@Param("identifierValue") String identifierValue);

}
