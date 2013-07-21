package org.celllife.idart.application.form;

import org.celllife.idart.domain.form.Form;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormResourceService {

    Form save(Form form);

    Form findByCode(String code);

    Iterable<Form> findAll();

}