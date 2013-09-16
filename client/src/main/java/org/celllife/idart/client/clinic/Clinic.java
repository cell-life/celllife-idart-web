package org.celllife.idart.client.clinic;

import org.celllife.idart.common.AuthorityId;
import org.celllife.idart.common.Identifier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static org.celllife.idart.common.Identifiers.newIdentifier;

/**
 * Date: 2013-07-18
 * Time: 20h25
 */
public final class Clinic implements Serializable {

    public Set<Identifier> identifiers;

    public Clinic() {
    }

    public void addIdentifier(AuthorityId authority, String value) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<Identifier>();
        }
        this.identifiers.add(newIdentifier(authority, value));
    }

}
