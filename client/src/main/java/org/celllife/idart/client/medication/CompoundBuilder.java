package org.celllife.idart.client.medication;

import org.celllife.idart.common.AuthorityId;
import org.celllife.idart.common.Code;
import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Id;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Compound;

import static org.celllife.idart.common.Identifiers.newIdentifier;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class CompoundBuilder {

    private final Compound compound;

    private final String clinicDrugsidentifiersystem;

    public CompoundBuilder(String clinicId) {
        this.compound = new Compound();
        this.clinicDrugsidentifiersystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/compounds", clinicId);
    }

    public CompoundBuilder setIdentifier(AuthorityId authority, String idValue) {
        this.compound.identifiers.add(newIdentifier(authority, idValue));
        return this;
    }

    public Compound finishCompound() {
        return compound;
    }

    public CompoundBuilder setForm(String formCodeValue) {
        this.compound.form = FormCode.formCode(formCodeValue);
        return this;
    }
}
