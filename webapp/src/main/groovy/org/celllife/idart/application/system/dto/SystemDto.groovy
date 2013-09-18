package org.celllife.idart.application.system.dto

import org.celllife.idart.common.Identifier

/**
 */
class SystemDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Application Key
     */
    String applicationKey
    
}
