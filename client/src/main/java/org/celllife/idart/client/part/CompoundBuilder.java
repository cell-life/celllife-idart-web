package org.celllife.idart.client.part;

import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Label;
import org.celllife.idart.common.SystemId;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
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

    public CompoundBuilder setForm(FormCode formCode) {
        this.compound.setForm(formCode);
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
