package org.celllife.idart.infrastructure.springdata.practitioner;

import org.celllife.idart.common.PersonId;
import org.celllife.idart.common.PractitionerId;
import org.celllife.idart.domain.practitioner.Practitioner;
import org.celllife.idart.domain.practitioner.PractitionerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 */
public interface SpringDataPractitionerRepository extends PractitionerRepository,
        PagingAndSortingRepository<Practitioner, PractitionerId> {

    @Query("select practitioner.person from Practitioner practitioner where practitioner.id = :practitionerId")
    PersonId findPersonByPractitionerId(@Param("practitionerId") PractitionerId practitionerId);

}
