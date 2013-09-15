package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodRepository {

    boolean exists(AdministrationMethodCode administrationMethodCode)

    AdministrationMethod save(AdministrationMethod administrationMethod)

    AdministrationMethod findOne(AdministrationMethodCode administrationMethodCode)

}
