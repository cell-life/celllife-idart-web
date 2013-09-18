package org.celllife.idart.client.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.common.Identifier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 13h53
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "MEDICATION", value = Medication.class)
})
public abstract class Product implements Serializable {

    private Set<Identifier> identifiers = new HashSet<Identifier>();

    private String name;

    protected Product() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
