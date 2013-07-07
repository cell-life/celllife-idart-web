package org.celllife.idart.domain.partyrole

import org.celllife.idart.domain.person.Person

import static org.celllife.idart.framework.aspectj.InjectIdentified.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h22
 */
abstract class PersonRole extends PartyRole {

    /**
     * Acted by
     */
    Person person

    void setPerson(Person person) {
        this.person = inject(person)
    }
}
