package org.celllife.idart.application.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidationException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodNotFoundException
import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.administrationmethod.AdministrationMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class AdministrationMethodApplicationServiceImpl implements AdministrationMethodApplicationService {

    @Autowired AdministrationMethodService administrationMethodService

    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException {
        administrationMethodService.save(administrationMethod)
    }

    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) throws AdministrationMethodNotFoundException{
        administrationMethodService.findByAdministrationMethodCode(administrationMethodCode)
    }

}