package org.celllife.idart.domain.form

import org.celllife.idart.domain.common.Code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
        formRepository.save(lookupAndMerge(form))
    }

    def lookupAndMerge(Form form) {

        def (String system, String value) = getLookupCode(form)

        Form existingForm = formRepository.findOneByCode(system, value)

        if (existingForm == null) {

            // Ensure that idartCodeValue is always set
            if (form.idartCodeValue == null) {
                form.addCode(form.idartSystem, form.defaultCodeValue)
            }

            return form
        }

        existingForm.mergeCodes(form)
        existingForm
    }

    static getLookupCode(Form form) {

        if (form.idartCodeValue == null && form.defaultCodeValue == null) {
            throw new RuntimeException("No code for default system [${ form.defaultSystem}] or idart system [${ form.idartSystem}]")
        }

        if (form.defaultCodeValue != null) {
            return [form.defaultSystem, form.defaultCodeValue]
        }

        return [form.idartSystem, form.idartCodeValue]
    }

    @Override
    Iterable<Form> findAll() {
        formRepository.findAll()
    }

    @Override
    Form findByCode(String code) {
        formRepository.findOneByCode(Form.IDART_SYSTEM, code)
    }

    @Override
    Form findByCodes(Iterable<Code> codes) {

        if (codes == null) {
            return null
        }

        for (code in codes) {
            def form = formRepository.findOneByCode(code.system, code.value)
            if (form != null) {
                return form
            }
        }

        null
    }
}