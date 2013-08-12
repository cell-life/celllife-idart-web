package org.celllife.idart.application.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidationException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodNotFoundException
import org.celllife.idart.common.AdministrationMethodCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AdministrationMethodApplicationService {

    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException

    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) throws AdministrationMethodNotFoundException

}