package org.celllife.idart.infrastructure.springdata.dispensation;

import org.celllife.idart.common.DispensationIdentifier;
import org.celllife.idart.domain.dispensation.Dispensation;
import org.celllife.idart.domain.dispensation.DispensationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDispensationRepository extends PagingAndSortingRepository<Dispensation, DispensationIdentifier>, DispensationRepository {

}