package org.celllife.idart.application.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.administrationmethod.AdministrationMethod

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AdministrationMethodApplicationService {

    AdministrationMethod save(AdministrationMethod administrationMethod)

    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode)

}
