package org.celllife.idart.client.encounter;

import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.SystemId;

import java.util.Date;
import java.util.Set;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class EncounterBuilder {

    private final Encounter encounter;

    private final SystemId systemId;

    public EncounterBuilder(String systemId) {
        this.encounter = new Encounter();
        this.systemId = systemId(systemId);
    }

    public EncounterBuilder setIdentifier(String identifier) {
        this.encounter.getIdentifiers().add(newIdentifier(systemId, identifier));
        return this;
    }

    public Encounter finishEncounter() {
        return encounter;
    }

    public EncounterBuilder setFacility(Set<Identifier> facility) {
        this.encounter.setFacility(facility);
        return this;
    }

    public EncounterBuilder setStartAt(Date startAt) {
        this.encounter.setStartedAt(startAt);
        return this;
    }
}
