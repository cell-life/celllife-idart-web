package org.celllife.idart.infrastructure.springdata.dispensation;

import org.celllife.idart.common.DispensationId;
import org.celllife.idart.domain.dispensation.Dispensation;
import org.celllife.idart.domain.dispensation.DispensationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataDispensationRepository extends DispensationRepository,
        PagingAndSortingRepository<Dispensation, DispensationId> {

}
