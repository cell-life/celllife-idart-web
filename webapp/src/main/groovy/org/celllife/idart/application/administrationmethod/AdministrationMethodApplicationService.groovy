package org.celllife.idart.application.administrationmethod

import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDto
import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AdministrationMethodApplicationService {

    Boolean exists(AdministrationMethodCode administrationMethodCode)

    AdministrationMethodCode save(AdministrationMethodDto administrationMethodDto)

    AdministrationMethodDto findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode)

    AdministrationMethodDto findByIdentifier(Identifier identifier)

    AdministrationMethodCode findByIdentifiers(Set<Identifier> identifiers)

}
