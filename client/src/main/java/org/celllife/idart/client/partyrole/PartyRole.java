package org.celllife.idart.client.partyrole;

import org.celllife.idart.client.person.Person;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.SystemId;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h23
 */
public abstract class PartyRole implements Serializable {

    public Person person;

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Date fromDate;

    public Date thruDate;

    public PartyRole() {
    }

    public String getIdentifierBySystem(SystemId system) {

        for (Identifier identifier : identifiers) {

            if (identifier == null) {
                continue;
            }

            if (identifier.getSystem() != null && identifier.getSystem().equals(system)) {
                return identifier.getValue();
            }
        }

        return null;
    }
}
