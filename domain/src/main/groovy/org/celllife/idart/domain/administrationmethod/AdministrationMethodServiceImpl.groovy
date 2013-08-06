package org.celllife.idart.domain.administrationmethod

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class AdministrationMethodServiceImpl implements AdministrationMethodService {

    @Autowired AdministrationMethodRepository administrationMethodRepository

    @Autowired AdministrationMethodValidator administrationMethodValidator

    @Override
    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException {

        administrationMethodValidator.validate(administrationMethod)

        administrationMethodRepository.save(administrationMethod)
    }

    @Override
    AdministrationMethod findByCode(AdministrationMethodCode code) throws AdministrationMethodNotFoundException {

        def administrationMethod = administrationMethodRepository.findOne(code)

        if (administrationMethod == null) {
            throw new AdministrationMethodNotFoundException("Could not find AdministrationMethod with Code [${ code}]")
        }

        administrationMethod
    }
}