package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode

import javax.annotation.Generated

/**
 * Substitution Reason 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReason {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/substitutionReasons"

    /**
     * Substitution Reason Code 
     */
    SubstitutionReasonCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}