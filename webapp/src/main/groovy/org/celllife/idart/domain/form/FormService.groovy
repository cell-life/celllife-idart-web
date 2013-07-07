package org.celllife.idart.domain.form

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
interface FormService {

    def save(Iterable<Form> forms)

    def save(Form form)

}
