package org.celllife.idart.application.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(FormApplicationServiceMixin)
class FormApplicationServiceImpl implements FormApplicationService, FormResourceService {

    @Autowired FormService formService

    Form save(Form form) {
        formService.save(form)
    }

    Form findByCode(String code) {
        formService.findByCode(code)
    }

    Iterable<Form> findAll() {
        formService.findAll()
    }

}