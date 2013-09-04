package org.celllife.idart.application.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodApplicationServiceImpl implements AdministrationMethodApplicationService {

    @Inject AdministrationMethodService administrationMethodService

    AdministrationMethod save(AdministrationMethod administrationMethod) {
        administrationMethodService.save(administrationMethod)
    }

    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) {
        administrationMethodService.findByAdministrationMethodCode(administrationMethodCode)
    }

}
