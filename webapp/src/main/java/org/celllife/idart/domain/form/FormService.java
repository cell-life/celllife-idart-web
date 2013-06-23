package org.celllife.idart.domain.form;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
public interface FormService {

    void save(Iterable<Form> forms);

    void save(Form form);

}
