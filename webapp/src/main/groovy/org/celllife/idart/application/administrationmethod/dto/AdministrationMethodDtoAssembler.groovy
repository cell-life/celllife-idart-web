package org.celllife.idart.application.administrationmethod.dto

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodDtoAssembler {

    AdministrationMethod toAdministrationMethod(AdministrationMethodDto administrationMethodDto) {

        def administrationMethod = new AdministrationMethod()
        administrationMethod.with {

        }

        administrationMethod
    }

    AdministrationMethodDto toAdministrationMethodDto(AdministrationMethod administrationMethod) {

        def administrationMethodDto = new AdministrationMethodDto()
        administrationMethodDto.with {

        }

        administrationMethodDto
    }
}
