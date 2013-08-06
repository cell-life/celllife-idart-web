package org.celllife.idart.domain.form

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FormServiceImpl implements FormService {

    @Autowired FormRepository formRepository

    @Autowired FormValidator formValidator

    @Override
    Form save(Form form) throws FormValidationException {

        formValidator.validate(form)

        formRepository.save(form)
    }

    @Override
    Form findByCode(FormCode code) throws FormNotFoundException {

        def form = formRepository.findOne(code)

        if (form == null) {
            throw new FormNotFoundException("Could not find Form with Code [${ code}]")
        }

        form
    }
}