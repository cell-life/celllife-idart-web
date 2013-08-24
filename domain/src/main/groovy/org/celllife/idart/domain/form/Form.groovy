package org.celllife.idart.domain.form

import org.celllife.idart.common.FormCode

import javax.annotation.Generated

/**
 * Form 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class Form {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/forms"

    /**
     * Form Code 
     */
    FormCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}
