package org.celllife.idart.infrastructure.springdata.system;

import org.celllife.idart.common.SystemId;
import org.celllife.idart.domain.system.System;
import org.celllife.idart.domain.system.SystemRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataSystemRepository extends SystemRepository,
        PagingAndSortingRepository<System, SystemId> {

}
