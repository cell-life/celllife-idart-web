package org.celllife.idart.domain.authority

import org.celllife.idart.common.AuthorityId

import javax.annotation.Generated

/**
 * Authority 
 *
 */
class Authority {

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
