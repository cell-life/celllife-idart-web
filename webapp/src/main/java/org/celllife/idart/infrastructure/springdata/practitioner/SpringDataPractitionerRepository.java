package org.celllife.idart.infrastructure.springdata.practitioner;

import org.celllife.idart.common.PractitionerIdentifier;
import org.celllife.idart.domain.practitioner.Practitioner;
import org.celllife.idart.domain.practitioner.PractitionerRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPractitionerRepository extends PractitionerRepository,
        PagingAndSortingRepository<Practitioner, PractitionerIdentifier> {

}