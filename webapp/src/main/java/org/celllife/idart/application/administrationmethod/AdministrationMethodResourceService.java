package org.celllife.idart.application.administrationmethod;

import org.celllife.idart.domain.administrationmethod.AdministrationMethod;

import javax.annotation.Generated;

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodResourceService {

    AdministrationMethod save(AdministrationMethod administrationMethod);

    AdministrationMethod findByCode(String code);

    Iterable<AdministrationMethod> findAll();

}