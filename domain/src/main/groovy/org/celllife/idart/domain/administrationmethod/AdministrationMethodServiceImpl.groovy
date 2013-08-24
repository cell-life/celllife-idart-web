package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent.EventType.SAVED
import static org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent.newAdministrationMethodEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class AdministrationMethodServiceImpl implements AdministrationMethodService {

    @Autowired AdministrationMethodRepository administrationMethodRepository

    @Autowired AdministrationMethodValidator administrationMethodValidator

    @Autowired AdministrationMethodEventPublisher administrationMethodEventPublisher

    @Override
    AdministrationMethod save(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException {

        administrationMethodValidator.validate(administrationMethod)

        administrationMethodEventPublisher.publish(newAdministrationMethodEvent(administrationMethod, SAVED))

        administrationMethodRepository.save(administrationMethod)
    }

    @Override
    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) throws AdministrationMethodNotFoundException {

        def administrationMethod = administrationMethodRepository.findOne(administrationMethodCode)

        if (administrationMethod == null) {
            throw new AdministrationMethodNotFoundException("Could not find AdministrationMethod with Administration Method Code [${ administrationMethodCode}]")
        }

        administrationMethod
    }
}
