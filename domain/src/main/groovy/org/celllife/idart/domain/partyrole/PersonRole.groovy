package org.celllife.idart.domain.partyrole

import org.celllife.idart.domain.person.Person

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h22
 */
abstract class PersonRole extends PartyRole {

    /**
     * Acted by
     */
    @NotNull
    Person person

    def merge(PersonRole that) {
        super.merge(that)
        this.person = that.person
    }
}
