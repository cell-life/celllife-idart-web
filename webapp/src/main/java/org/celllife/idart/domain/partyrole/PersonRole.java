package org.celllife.idart.domain.partyrole;

import org.celllife.idart.domain.person.Person;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h22
 */
public abstract class PersonRole extends PartyRole {

    /**
     * Acted by
     */
    private Person person;

    protected PersonRole() {
    }
}
