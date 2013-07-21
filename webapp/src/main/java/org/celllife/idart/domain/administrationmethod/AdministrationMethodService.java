package org.celllife.idart.domain.administrationmethod;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodService {

    Iterable<AdministrationMethod> save(Iterable<AdministrationMethod> administrationMethods);

    AdministrationMethod save(AdministrationMethod administrationMethod);

    Iterable<AdministrationMethod> findAll();

    AdministrationMethod findByIdentifier(String identifier);

}