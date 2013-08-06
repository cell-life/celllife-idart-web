package org.celllife.idart.infrastructure.springdata.administrationmethod;

import org.celllife.idart.domain.administrationmethod.AdministrationMethod;
import org.celllife.idart.domain.administrationmethod.AdministrationMethodCode;
import org.celllife.idart.domain.administrationmethod.AdministrationMethodRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataAdministrationMethodRepository extends PagingAndSortingRepository<AdministrationMethod, AdministrationMethodCode>, AdministrationMethodRepository {

}
