package org.celllife.idart.application.system.dto

import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
class SystemDto {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Application Key
     */
    String applicationKey
    
}
