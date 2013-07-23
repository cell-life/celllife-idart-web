package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Compound;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class CompoundBuilder {

    private final Compound compound;

    private final String clinicDrugsIdentifierSystem;

    public CompoundBuilder(String clinicIdentifier) {
        this.compound = new Compound();
        this.clinicDrugsIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/compounds", clinicIdentifier);
    }

    public CompoundBuilder setIdentifier(String identifierValue) {
        this.compound.identifiers.add(new Identifier(this.clinicDrugsIdentifierSystem, identifierValue));
        return this;
    }

    public CompoundBuilder setIdentifier(String identifierSystem, String identifierValue) {
        this.compound.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public Compound finishCompound() {
        return compound;
    }

    public CompoundBuilder setForm(String formCodeSystem, String formCodeValue) {
        this.compound.form = new Form();
        this.compound.form.codes.add(new Code(formCodeSystem, formCodeValue));
        return this;
    }
}
