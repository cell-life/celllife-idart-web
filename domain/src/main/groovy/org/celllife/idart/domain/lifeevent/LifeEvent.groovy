package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import javax.annotation.Generated

/**
 * Life Event 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEvent implements Serializable {

    /**
     * Life Event Code 
     */
    LifeEventCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}
