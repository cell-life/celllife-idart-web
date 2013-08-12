package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EntrySiteCode

import javax.annotation.Generated

/**
 * Entry Site 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySite {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/entrySites"

    /**
     * Entry Site Code 
     */
    EntrySiteCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}