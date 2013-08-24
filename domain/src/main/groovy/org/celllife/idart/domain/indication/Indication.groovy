package org.celllife.idart.domain.indication

import org.celllife.idart.common.IndicationCode

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
     * Indication Code 
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
