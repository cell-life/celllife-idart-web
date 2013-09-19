package org.celllife.idart.client.dispensation;

import org.celllife.idart.common.Identifier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h51
 */
public final class Dispensation implements Serializable {

    private Set<Identifier> identifiers;

    private Set<Identifier> patient;

    private Set<Identifier> dispenser;

    private Set<Identifier> facility;

    private Date handedOver;

    private Set<DispensedMedication> dispensedMedications = new HashSet<DispensedMedication>();

    public Dispensation() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Set<Identifier> getPatient() {
        return patient;
    }

    public void setPatient(Set<Identifier> patient) {
        this.patient = patient;
    }

    public Set<Identifier> getDispenser() {
        return dispenser;
    }

    public void setDispenser(Set<Identifier> dispenser) {
        this.dispenser = dispenser;
    }

    public Set<Identifier> getFacility() {
        return facility;
    }

    public void setFacility(Set<Identifier> facility) {
        this.facility = facility;
    }

    public Date getHandedOver() {
        return handedOver;
    }

    public void setHandedOver(Date handedOver) {
        this.handedOver = handedOver;
    }

    public Set<DispensedMedication> getDispensedMedications() {
        return dispensedMedications;
    }

    public void setDispensedMedications(Set<DispensedMedication> dispensedMedications) {
        this.dispensedMedications = dispensedMedications;
    }
}
