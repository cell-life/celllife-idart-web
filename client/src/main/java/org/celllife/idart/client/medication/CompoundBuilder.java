package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.Id;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Compound;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class CompoundBuilder {

    private final Compound compound;

    private final String clinicDrugsIdSystem;

    public CompoundBuilder(String clinicId) {
        this.compound = new Compound();
        this.clinicDrugsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/compounds", clinicId);
    }

    public CompoundBuilder setId(String idValue) {
        this.compound.ids.add(new Id(idValue));
        return this;
    }

    public CompoundBuilder setId(String idSystem, String idValue) {
        this.compound.ids.add(new Id(idValue));
        return this;
    }

    public Compound finishCompound() {
        return compound;
    }

    public CompoundBuilder setForm(String formCodeSystem, String formCodeValue) {
        this.compound.form = new Form();
        this.compound.form.codes.add(new Code(formCodeValue));
        return this;
    }
}
