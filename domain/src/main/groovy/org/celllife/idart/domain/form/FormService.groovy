package org.celllife.idart.domain.form;

import org.celllife.idart.domain.common.Code;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormService {

    Iterable<Form> save(Iterable<Form> forms);

    Form save(Form form);

    Iterable<Form> findAll();

    Form findByCode(String code);

    Form findByCodes(Iterable<Code> codes);

}