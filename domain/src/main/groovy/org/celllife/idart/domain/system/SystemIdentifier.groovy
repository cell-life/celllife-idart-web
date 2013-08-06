package org.celllife.idart.domain.system

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

import javax.persistence.Embeddable

/**
 * System Identifier
 *
 */
@Embeddable
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
}