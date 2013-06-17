package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Period;
import org.celllife.idart.udm.codedconcept.Indication;
import org.celllife.idart.udm.codedconcept.Substitution;
import org.celllife.idart.udm.codedconcept.SubstitutionReason;
import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.udm.common.Duration;
import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.udm.product.Good;

import javax.persistence.*;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
@Entity
public final class PrescribedMedication extends BaseEntity {

    @ManyToOne(optional = false)
    private Good medication;

    private String reasonForPrescribing;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Indication> indications;

    @AttributeOverrides({
            @AttributeOverride(name = "fromDate", column = @Column(name = "validFromDate")),
            @AttributeOverride(name = "thruDate", column = @Column(name = "validThruDate"))
    })
    private Period valid;

    private Integer numberOfRepeats;

    @AttributeOverride(name = "value", column = @Column(name = "quantity"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "quantityUom"))
    private Quantity quantity;

    @AttributeOverride(name = "value", column = @Column(name = "expectedSupplyDuration"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "expectedSupplyDurationUom"))
    private Duration expectedSupplyDuration;

    @ManyToOne(optional = false)
    private Substitution substitution;

    @ManyToOne
    private SubstitutionReason substitutionReason;

    public PrescribedMedication() {
    }

    public Good getMedication() {
        return medication;
    }

    public void setMedication(Good medication) {
        this.medication = medication;
    }

    public String getReasonForPrescribing() {
        return reasonForPrescribing;
    }

    public void setReasonForPrescribing(String reasonForPrescribing) {
        this.reasonForPrescribing = reasonForPrescribing;
    }

    public Set<Indication> getIndications() {
        return indications;
    }

    public void setIndications(Set<Indication> reasonForPrescribingIndications) {
        this.indications = reasonForPrescribingIndications;
    }

    public Period getValid() {
        return valid;
    }

    public void setValid(Period valid) {
        this.valid = valid;
    }

    public Integer getNumberOfRepeats() {
        return numberOfRepeats;
    }

    public void setNumberOfRepeats(Integer numberOfRepeats) {
        this.numberOfRepeats = numberOfRepeats;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Duration getExpectedSupplyDuration() {
        return expectedSupplyDuration;
    }

    public void setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.expectedSupplyDuration = expectedSupplyDuration;
    }

    public Substitution getSubstitution() {
        return substitution;
    }

    public void setSubstitution(Substitution substitution) {
        this.substitution = substitution;
    }

    public SubstitutionReason getSubstitutionReason() {
        return substitutionReason;
    }

    public void setSubstitutionReason(SubstitutionReason substitutionReason) {
        this.substitutionReason = substitutionReason;
    }
}
