package org.celllife.idart.domain.user

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

import javax.persistence.Embeddable

/**
 * User Identifier
 *
 */
@Embeddable
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
}