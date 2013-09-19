package org.celllife.idart.client.dispensation;

import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.common.*;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class DispensedMedication implements Serializable {

    private Set<Identifier> medication;

    private Quantity quantity;

    private Period prepared;

    private DosageInstruction dosageInstruction;

    private Duration expectedSupplyDuration;

    private Set<Identifier> authorizingPrescribedMedication;

    public DispensedMedication() {
    }

    public Set<Identifier> getMedication() {
        return medication;
    }

    public void setMedication(Set<Identifier> medication) {
        this.medication = medication;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Period getPrepared() {
        return prepared;
    }

    public void setPrepared(Period prepared) {
        this.prepared = prepared;
    }

    public DosageInstruction getDosageInstruction() {
        return dosageInstruction;
    }

    public void setDosageInstruction(DosageInstruction dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }

    public Duration getExpectedSupplyDuration() {
        return expectedSupplyDuration;
    }

    public void setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.expectedSupplyDuration = expectedSupplyDuration;
    }

    public Set<Identifier> getAuthorizingPrescribedMedication() {
        return authorizingPrescribedMedication;
    }

    public void setAuthorizingPrescribedMedication(Set<Identifier> authorizingPrescribedMedication) {
        this.authorizingPrescribedMedication = authorizingPrescribedMedication;
    }
}
