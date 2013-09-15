package org.celllife.idart.application.administrationmethod.dto

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodDtoAssembler {

    static AdministrationMethod toAdministrationMethod(AdministrationMethodDto administrationMethodDto) {

        def administrationMethod = new AdministrationMethod()
        administrationMethod.with {

        }

        administrationMethod
    }

    static AdministrationMethodDto toAdministrationMethodDto(AdministrationMethod administrationMethod) {

        def administrationMethodDto = new AdministrationMethodDto()
        administrationMethodDto.with {

        }

        administrationMethodDto
    }
}
