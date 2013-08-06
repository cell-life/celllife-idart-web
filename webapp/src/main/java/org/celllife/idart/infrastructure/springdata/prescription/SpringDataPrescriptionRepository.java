package org.celllife.idart.infrastructure.springdata.prescription;

import org.celllife.idart.domain.prescription.Prescription;
import org.celllife.idart.domain.prescription.PrescriptionRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPrescriptionRepository extends PagingAndSortingRepository<Prescription, Long>, PrescriptionRepository {

    @Query("select prescription " +
            "from Prescription prescription " +
            "join prescription.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Prescription findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct prescription " +
            "from Prescription prescription " +
            "join prescription.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Prescription> findByIdentifier(@Param("identifierValue") String identifierValue);

}
