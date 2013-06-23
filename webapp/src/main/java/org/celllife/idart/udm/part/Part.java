package org.celllife.idart.udm.part;

import org.celllife.idart.domain.form.Form;
import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class Part extends BaseEntity {

    @NotNull
    private String name;

    @ManyToOne
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne
    private Form form;

    protected Part() {
    }

    protected Part(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
