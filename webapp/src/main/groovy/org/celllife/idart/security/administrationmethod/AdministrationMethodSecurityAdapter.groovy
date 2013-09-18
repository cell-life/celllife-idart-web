package org.celllife.idart.security.administrationmethod

import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDto
import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.common.Identifier
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

    AdministrationMethodCode save(Principal principal, AdministrationMethodDto administrationMethodDto) {
        administrationMethodApplicationService.save(administrationMethodDto)
    }

    AdministrationMethodDto findByAdministrationMethodCode(Principal principal, AdministrationMethodCode administrationMethodCode) {
        administrationMethodApplicationService.findByAdministrationMethodCode(administrationMethodCode)
    }

    AdministrationMethodDto findByIdentifier(Principal principal, Identifier identifier) {
        administrationMethodApplicationService.findByIdentifier(identifier)
    }

}
