package org.celllife.idart.domain.form;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormService {

    Iterable<Form> save(Iterable<Form> forms);

    Form save(Form form);

    Iterable<Form> findAll();

    Form findByIdentifier(String identifier);

}