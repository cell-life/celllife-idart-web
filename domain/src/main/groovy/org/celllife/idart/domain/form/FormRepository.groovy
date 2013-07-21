package org.celllife.idart.domain.form;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormRepository {

    Form save(Form form)

    public <S extends Form> Iterable<S> save(Iterable<S> forms)

    Form findOne(Long pk)

    Iterable<Form> findAll()

    Form findOneByCode(String system, String code);

}
