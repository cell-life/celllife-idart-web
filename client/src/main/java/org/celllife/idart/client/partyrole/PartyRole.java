package org.celllife.idart.client.partyrole;

import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.person.Person;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h23
 */
public class PartyRole implements Serializable {

    public Person person;

    public Set<Identifier> identifiers;

    public Date fromDate;

    public Date thruDate;

    public PartyRole() {
    }

    public String getIdentifierBySytem(String system) {

        for (Identifier identifier : identifiers) {

            if (identifier == null) {
                continue;
            }

            if (identifier.system != null && identifier.system.equals(system)) {
                return identifier.value;
            }
        }

        return null;
    }
}