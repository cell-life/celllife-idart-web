package org.celllife.idart.domain.indication

import javax.annotation.Generated

/**
 * Indication 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class Indication {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/indications"

    /**
     * Code 
     */
    IndicationCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}