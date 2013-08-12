package org.celllife.idart.domain.form

import org.celllife.idart.common.FormCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FormServiceImpl implements FormService {

    @Autowired FormRepository formRepository

    @Autowired FormValidator formValidator

    @Autowired FormEventPublisher formEventPublisher

    @Override
    Form save(Form form) throws FormValidationException {

        formValidator.validate(form)

        formEventPublisher.formSaved(form)

        formRepository.save(form)
    }

    @Override
    Form findByFormCode(FormCode formCode) throws FormNotFoundException {

        def form = formRepository.findOne(formCode)

        if (form == null) {
            throw new FormNotFoundException("Could not find Form with Form Code [${ formCode}]")
        }

        form
    }
}