package org.celllife.idart.domain.partyrole;

import org.celllife.idart.domain.person.Person;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 20h31
 */
privileged aspect PersonRole_JavaBean {

    public Person PersonRole.getPerson() {
        return person;
    }

    public void PersonRole.setPerson(Person person) {
        this.person = person;
    }
}
