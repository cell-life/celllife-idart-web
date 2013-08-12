package org.celllife.idart.infrastructure.springdata.lifeevent;

import org.celllife.idart.common.LifeEventCode;
import org.celllife.idart.domain.lifeevent.LifeEvent;
import org.celllife.idart.domain.lifeevent.LifeEventRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataLifeEventRepository extends PagingAndSortingRepository<LifeEvent, LifeEventCode>, LifeEventRepository {

}