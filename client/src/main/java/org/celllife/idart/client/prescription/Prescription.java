package org.celllife.idart.client.prescription;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.common.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h51
 */
public final class Prescription implements Serializable {

    private static final long serialVersionUID = -7566900518592446141L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Prescription.class);

    private Set<Identifier> identifiers = new HashSet<Identifier>();

    private Set<Identifier> prescriber = new HashSet<Identifier>();

    private Set<Identifier> patient = new HashSet<Identifier>();

    private Date dateWritten;

    private Encounter encounter;

    private Set<PrescribedMedication> prescribedMedications = new HashSet<PrescribedMedication>();

    public Prescription() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }
    
    public String getFirstIdentifier() {
        String firstId = "";
    	if (identifiers.size() > 1) {
    	    LOGGER.warn("Prescription has more than 1 identifier. "+this.getIdentifiers());
    	} else if (identifiers.size() == 0) {
    	    LOGGER.warn("Prescription has no identifiers. ");
    	} else {
    	    Identifier id = this.identifiers.iterator().next();
    	    if (id != null) {
    	        firstId = id.getValue();
    	    }
    	}
    	return firstId;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Set<Identifier> getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(Set<Identifier> prescriber) {
        this.prescriber = prescriber;
    }

    public Set<Identifier> getPatient() {
        return patient;
    }

    public void setPatient(Set<Identifier> patient) {
        this.patient = patient;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Set<PrescribedMedication> getPrescribedMedications() {
        return prescribedMedications;
    }

    public void setPrescribedMedications(Set<PrescribedMedication> prescribedMedications) {
        this.prescribedMedications = prescribedMedications;
    }
}
