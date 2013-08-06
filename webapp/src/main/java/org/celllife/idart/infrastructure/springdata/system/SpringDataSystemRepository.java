package org.celllife.idart.infrastructure.springdata.system;

import org.celllife.idart.domain.system.System;
import org.celllife.idart.domain.system.SystemIdentifier;
import org.celllife.idart.domain.system.SystemRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSystemRepository extends PagingAndSortingRepository<System, SystemIdentifier>, SystemRepository {

}
