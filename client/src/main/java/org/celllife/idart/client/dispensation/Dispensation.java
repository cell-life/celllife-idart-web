package org.celllife.idart.client.dispensation;

import org.celllife.idart.common.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final long serialVersionUID = 2494899951224742476L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Dispensation.class);

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

    public String getFirstIdentifier() {
        String firstId = "";
        if (identifiers.size() > 1) {
            LOGGER.warn("Dispensation has more than 1 identifier. "+this.getIdentifiers());
        } else if (identifiers.size() == 0) {
            LOGGER.warn("Dispensation has no identifiers. ");
        } else {
            Identifier id = this.identifiers.iterator().next();
            if (id != null) {
                firstId = id.getValue();
            }
        }
        return firstId;
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
