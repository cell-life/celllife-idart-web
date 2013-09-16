package org.celllife.idart.domain.form

import org.celllife.idart.common.FormCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.form.FormEvent.EventType.SAVED
import static org.celllife.idart.domain.form.FormEvent.newFormEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormServiceImpl implements FormService {

    @Inject FormRepository formRepository

    @Inject FormValidator formValidator

    @Inject FormEventPublisher formEventPublisher

    @Override
    Boolean exists(FormCode formCode) {
        formRepository.exists(formCode)
    }

    @Override
    Form save(Form form) {

        def existingForm = formRepository.findOne(form.id)

        if (existingForm == null) {
            existingForm = form
        } else {
            existingForm.merge(form)
        }

        formValidator.validate(existingForm)

        formEventPublisher.publish(newFormEvent(existingForm, SAVED))

        formRepository.save(existingForm)
    }

    @Override
    Form findByFormCode(FormCode formCode) {

        def form = formRepository.findOne(formCode)

        if (form == null) {
            throw new FormNotFoundException("Could not find Form with code [${ formCode}]")
        }

        form
    }
}
