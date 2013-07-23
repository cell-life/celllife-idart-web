package org.celllife.idart.client.clinic;

import org.celllife.idart.client.common.Identifier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2013-07-18
 * Time: 20h25
 */
public final class Clinic implements Serializable {

    public Set<Identifier> identifiers;

    public Clinic() {
    }

    public void addIdentifier(String system, String value) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<Identifier>();
        }
        this.identifiers.add(new Identifier(system, value));
    }

}
