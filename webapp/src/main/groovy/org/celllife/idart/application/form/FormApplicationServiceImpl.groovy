package org.celllife.idart.application.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.domain.form.FormCode
import org.celllife.idart.domain.form.FormService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FormApplicationServiceImpl implements FormApplicationService {

    @Autowired FormService formService

    Form save(Form form) throws FormValidationException {
        formService.save(form)
    }

    Form findByCode(FormCode code) throws FormNotFoundException{
        formService.findByCode(code)
    }

}