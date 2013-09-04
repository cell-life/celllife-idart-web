package org.celllife.idart.security.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.application.administrationmethod.AdministrationMethodApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodSecurityAdapter {

    @Inject AdministrationMethodApplicationService administrationMethodApplicationService

    AdministrationMethod save(Principal principal, AdministrationMethod administrationMethod) {
        administrationMethodApplicationService.save(administrationMethod)
    }

    AdministrationMethod findByAdministrationMethodCode(Principal principal, AdministrationMethodCode administrationMethodCode) {
        administrationMethodApplicationService.findByAdministrationMethodCode(administrationMethodCode)
    }

}
