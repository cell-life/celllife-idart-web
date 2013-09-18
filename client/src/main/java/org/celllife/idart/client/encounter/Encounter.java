package org.celllife.idart.client.encounter;

import org.celllife.idart.common.Identifier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class Encounter implements Serializable {

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Set<Identifier> facility = new HashSet<Identifier>();

    public Date startedAt;

    public Encounter() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Set<Identifier> getFacility() {
        return facility;
    }

    public void setFacility(Set<Identifier> facility) {
        this.facility = facility;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }
}
