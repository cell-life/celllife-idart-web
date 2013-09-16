package org.celllife.idart.client.part;

import org.celllife.idart.common.Id;
import org.celllife.idart.client.form.Form;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.PartClassificationCode;

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
        @JsonSubTypes.Type(name = "DRUG", value = Drug.class),
        @JsonSubTypes.Type(name = "COMPOUND", value = Compound.class)
})
public abstract class Part implements Serializable {

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Set<Identifier> unitOfMeasure;

    public FormCode form;

    public Set<PartClassificationCode> classifications = new HashSet<PartClassificationCode>();

    protected Part() {
    }
}
