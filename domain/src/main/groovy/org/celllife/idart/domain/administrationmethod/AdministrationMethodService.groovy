package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodService {

    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException

    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) throws AdministrationMethodNotFoundException

}