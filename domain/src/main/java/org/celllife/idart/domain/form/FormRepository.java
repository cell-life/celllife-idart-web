package org.celllife.idart.domain.form;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormRepository {

    Form findOneByCode(String system, String code);

}
