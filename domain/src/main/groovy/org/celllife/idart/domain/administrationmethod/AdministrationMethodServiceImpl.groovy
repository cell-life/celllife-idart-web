package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent.EventType.SAVED
import static org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent.newAdministrationMethodEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AdministrationMethodServiceImpl implements AdministrationMethodService {

    @Inject AdministrationMethodRepository administrationMethodRepository

    @Inject AdministrationMethodValidator administrationMethodValidator

    @Inject AdministrationMethodEventPublisher administrationMethodEventPublisher

    @Override
    AdministrationMethod save(AdministrationMethod administrationMethod) {

        administrationMethodValidator.validate(administrationMethod)

        administrationMethodEventPublisher.publish(newAdministrationMethodEvent(administrationMethod, SAVED))

        administrationMethodRepository.save(administrationMethod)
    }

    @Override
    AdministrationMethod findByAdministrationMethodCode(AdministrationMethodCode administrationMethodCode) {

        def administrationMethod = administrationMethodRepository.findOne(administrationMethodCode)

        if (administrationMethod == null) {
            throw new AdministrationMethodNotFoundException("Could not find AdministrationMethod with Administration Method Code [${ administrationMethodCode}]")
        }

        administrationMethod
    }
}
