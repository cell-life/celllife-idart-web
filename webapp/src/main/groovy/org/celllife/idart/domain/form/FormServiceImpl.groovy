package org.celllife.idart.domain.form

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
@Service class FormServiceImpl implements FormService {

    @Autowired FormRepository formRespository

    def save(Iterable<Form> forms) {
        forms.each { form -> save(form) }
    }

    def save(Form form) {

        String system = form.getFirstSystem()
        String code = form.getCodeValue(system)

        Form savedForm = formRespository.findOneBySystemAndCode(system, code)
        if (savedForm != null) {
            savedForm.mergeCodes(form)
            formRespository.save(savedForm)
        } else {
            formRespository.save(form)
        }
    }
}
