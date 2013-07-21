package org.celllife.idart.client.part;

import org.celllife.idart.client.common.Coded;
import org.celllife.idart.client.common.Identifier;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "compound", value = Compound.class),
        @JsonSubTypes.Type(name = "drug", value = Drug.class),
        @JsonSubTypes.Type(name = "drugGroup", value = DrugGroup.class)
})
public abstract class Part implements Serializable {

    public Set<Identifier> identifiers;

    public Coded unitOfMeasure;

    public Coded form;

    public Set<PartClassification> classifications;

    protected Part() {
    }

    @Override
    public String toString() {
        return "Part{" +
                "identifiers=" + identifiers +
                ", unitOfMeasure=" + unitOfMeasure +
                ", form=" + form +
                ", classifications=" + classifications +
                '}';
    }
}
