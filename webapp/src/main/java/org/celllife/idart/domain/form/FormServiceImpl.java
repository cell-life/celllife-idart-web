package org.celllife.idart.domain.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
@Service("formService")
public final class FormServiceImpl implements FormService {

    @Autowired
    private FormRespository formRespository;

    public void save(Iterable<Form> forms) {
        for (Form form : forms) {
            save(form);
        }
    }

    public void save(Form form) {

        String system = form.getFirstSystem();
        String code = form.getCodeValue(system);

        Form savedForm = formRespository.findOneBySystemAndCode(system, code);
        if (savedForm != null) {
            savedForm.mergeCodes(form);
            formRespository.save(savedForm);
        } else {
            formRespository.save(form);
        }
    }
}
