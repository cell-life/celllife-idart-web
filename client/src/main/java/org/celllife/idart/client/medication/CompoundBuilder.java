package org.celllife.idart.client.medication;

import org.celllife.idart.common.SystemId;
import org.celllife.idart.common.FormCode;
import org.celllife.idart.client.part.Compound;

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

    public CompoundBuilder setIdentifier(SystemId system, String idValue) {
        this.compound.getIdentifiers().add(newIdentifier(system, idValue));
        return this;
    }

    public Compound finishCompound() {
        return compound;
    }

    public CompoundBuilder setForm(String formCodeValue) {
        this.compound.setForm(FormCode.formCode(formCodeValue));
        return this;
    }
}
