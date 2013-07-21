package org.celllife.idart.domain.form

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FormServiceImpl implements FormService {

    @Autowired FormRepository formRepository

    @Override
    Iterable<Form> save(Iterable<Form> forms) {
        forms.collect { form -> (save(form)) }
    }

    @Override
    Form save(Form form) {

        String system = form.getFirstSystem()
        String code = form.getCodeValue(system)

        Form savedForm = formRepository.findOneByCode(system, code)

        if (savedForm != null) {
            savedForm.mergeCodes(form)
            return formRepository.save(savedForm)
        } else {
            return formRepository.save(form)
        }
    }              
    
    @Override
    Iterable<Form> findAll() {
        formRepository.findAll()
    }

    @Override
    Form findByIdentifier(String identifier) {
        null
    }
}