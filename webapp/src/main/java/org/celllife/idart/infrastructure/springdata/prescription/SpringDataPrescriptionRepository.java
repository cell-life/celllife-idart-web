package org.celllife.idart.infrastructure.springdata.prescription;

import org.celllife.idart.domain.prescription.Prescription;
import org.celllife.idart.domain.prescription.PrescriptionRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h12
 */
@RestResource(path = "prescriptions")
public interface SpringDataPrescriptionRepository extends PrescriptionRepository, PagingAndSortingRepository<Prescription, Long> {

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
