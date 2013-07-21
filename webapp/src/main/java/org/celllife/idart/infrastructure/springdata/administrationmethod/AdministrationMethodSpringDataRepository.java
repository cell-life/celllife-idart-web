package org.celllife.idart.domain.administrationmethod;

import org.springframework.data.repository.CrudRepository;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h18
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodSpringDataRepository
        extends AdministrationMethodRepository, CrudRepository<AdministrationMethod, Long> {

    AdministrationMethod findOneByCode(String system, String code);

}
