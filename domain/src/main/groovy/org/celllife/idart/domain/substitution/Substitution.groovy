package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import javax.annotation.Generated

/**
 * Substitution 
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class Substitution {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/substitutions"

    /**
     * Substitution Code 
     */
    SubstitutionCode code
    
    /**
     * Name 
     */
    String name
    
    /**
     * Description 
     */
    String description
    
}
