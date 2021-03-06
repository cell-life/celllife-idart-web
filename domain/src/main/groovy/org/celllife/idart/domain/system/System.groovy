package org.celllife.idart.domain.system

import groovy.transform.ToString

import org.celllife.idart.common.SystemId

/**
 * System 
 *
 */
@ToString
class System implements Serializable {

    /**
     * Id
     */
    SystemId id

    /**
     * Application Key
     */
    String applicationKey

    def merge(System that) {

        if (that.applicationKey != null) {
            this.applicationKey = that.applicationKey
        }
    }
}
