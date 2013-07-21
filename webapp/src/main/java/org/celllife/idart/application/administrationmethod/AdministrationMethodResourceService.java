package org.celllife.idart.application.administrationmethod;

import org.celllife.idart.domain.administrationmethod.AdministrationMethod;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodResourceService {

    AdministrationMethod save(AdministrationMethod administrationMethod);

    AdministrationMethod findByCode(String code);

    Iterable<AdministrationMethod> findAll();

}