package org.celllife.idart.client.part;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

import org.celllife.idart.common.Label;
import org.celllife.idart.common.SystemId;

/**
 * Handy class that allows you to create Compounds.
 * Like so
 * <pre>
        Compound compound = new CompoundBuilder(clinicId)
                .setIdentifier("Abacavir")
                .setLabel(label("Abacavir"))
                .finishCompound();
 * </pre>
 */
public class CompoundBuilder {

    private final Compound compound;

    private final SystemId systemId;

    public CompoundBuilder(String systemId) {
        this.compound = new Compound();
        this.systemId = systemId(systemId);
    }

    public CompoundBuilder setIdentifier(String idValue) {
        this.compound.getIdentifiers().add(newIdentifier(systemId, idValue));
        return this;
    }

    public CompoundBuilder setLabel(Label label) {
        this.compound.setLabel(label);
        return this;
    }

    public Compound finishCompound() {
        return compound;
    }
}
