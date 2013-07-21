package org.celllife.idart.domain.administrationmethod;

import org.celllife.idart.domain.common.Code;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodService {

    Iterable<AdministrationMethod> save(Iterable<AdministrationMethod> administrationMethods);

    AdministrationMethod save(AdministrationMethod administrationMethod);

    Iterable<AdministrationMethod> findAll();

    AdministrationMethod findByCode(String code);

    AdministrationMethod findByCodes(Iterable<Code> codes);

}