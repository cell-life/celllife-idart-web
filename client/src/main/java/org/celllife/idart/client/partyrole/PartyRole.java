package org.celllife.idart.client.partyrole;

import org.celllife.idart.common.Id;
import org.celllife.idart.client.person.Person;

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

    public String getIdBySytem(String system) {

        for (Id id : identifiers) {

            if (id == null) {
                continue;
            }

            if (id.system != null && id.system.equals(system)) {
                return id.value;
            }
        }

        return null;
    }
}
