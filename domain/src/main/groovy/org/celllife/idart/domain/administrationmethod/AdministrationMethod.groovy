package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode

import javax.annotation.Generated

/**
 * Administration Method - The method in which medication is administered 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethod {

    /**
     * Administration Method Code 
     */
    AdministrationMethodCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}
