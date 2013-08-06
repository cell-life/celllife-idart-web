package org.celllife.idart.infrastructure.springdata.lifeevent;

import org.celllife.idart.domain.lifeevent.LifeEvent;
import org.celllife.idart.domain.lifeevent.LifeEventCode;
import org.celllife.idart.domain.lifeevent.LifeEventRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataLifeEventRepository extends PagingAndSortingRepository<LifeEvent, LifeEventCode>, LifeEventRepository {

}
