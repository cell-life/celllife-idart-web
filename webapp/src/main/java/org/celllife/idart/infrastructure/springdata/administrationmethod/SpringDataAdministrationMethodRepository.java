package org.celllife.idart.infrastructure.springdata.administrationmethod;

import org.celllife.idart.common.AdministrationMethodCode;
import org.celllife.idart.domain.administrationmethod.AdministrationMethod;
import org.celllife.idart.domain.administrationmethod.AdministrationMethodRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataAdministrationMethodRepository extends AdministrationMethodRepository,
        PagingAndSortingRepository<AdministrationMethod, AdministrationMethodCode> {

}