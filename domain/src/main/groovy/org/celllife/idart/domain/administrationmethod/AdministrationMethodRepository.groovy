package org.celllife.idart.domain.administrationmethod

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodRepository {

    AdministrationMethod save(AdministrationMethod administrationMethod)

    AdministrationMethod findOne(AdministrationMethodCode code)

}
