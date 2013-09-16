package org.celllife.idart.domain.authority

import org.celllife.idart.common.AuthorityId

/**
 * Authority 
 *
 */
class Authority implements Serializable {

    /**
     * Authority Id 
     */
    AuthorityId id

    String name

    String description

    def merge(Authority that) {

        if (that == null) {
            return
        }

        this.name = that.name
        this.description = that.description
    }
}
