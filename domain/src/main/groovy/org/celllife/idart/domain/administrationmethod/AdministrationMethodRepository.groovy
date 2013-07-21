package org.celllife.idart.domain.administrationmethod;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodRepository {

    AdministrationMethod save(AdministrationMethod administrationMethod)

    public <S extends AdministrationMethod> Iterable<S> save(Iterable<S> administrationMethods)

    AdministrationMethod findOne(Long pk)

    Iterable<AdministrationMethod> findAll()

    AdministrationMethod findOneByCode(String system, String code);

}
