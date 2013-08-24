package org.celllife.idart.client.part;

import org.celllife.idart.client.common.Id;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "compound", value = Compound.class),
        @JsonSubTypes.Type(name = "drug", value = Drug.class)
})
public abstract class Part implements Serializable {

    public Set<Id> ids = new HashSet<Id>();

    public UnitOfMeasure unitOfMeasure;

    public Form form;

    public Set<PartClassification> classifications = new HashSet<PartClassification>();

    protected Part() {
    }

    @Override
    public String toString() {
        return "Part{" +
                "ids=" + ids +
                ", unitOfMeasure=" + unitOfMeasure +
                ", form=" + form +
                ", classifications=" + classifications +
                '}';
    }
}
