package org.celllife.idart.domain.administrationmethod

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodService {

    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException

    AdministrationMethod findByCode(AdministrationMethodCode code) throws AdministrationMethodNotFoundException

}