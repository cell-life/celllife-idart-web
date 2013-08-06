package org.celllife.idart.domain.administrationmethod

import javax.annotation.Generated

/**
 * Administration Method - The method in which medication is administered 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethod {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/administrationMethods"

    /**
     * Code 
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