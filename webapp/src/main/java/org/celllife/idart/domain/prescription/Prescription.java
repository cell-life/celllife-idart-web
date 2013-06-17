package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.udm.partyrole.Practitioner;
import org.celllife.idart.udm.partyrole.UdmPatient;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h49
 */
@Entity
public final class Prescription extends BaseEntity {

    /**
     * Identified by
     */
    @ElementCollection
    private Set<Identifier> identifiers;

    @ManyToOne
    private Practitioner prescriber;

    @ManyToOne(optional = false)
    private UdmPatient patient;

    @Temporal(TemporalType.DATE)
    private Date dateWritten;

//    @ManyToOne(optional = false)
//    private Visit visit;

    @JoinColumn(name = "Prescription")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PrescribedMedication> prescribedMedications;

    public Prescription() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Practitioner getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(Practitioner prescriber) {
        this.prescriber = prescriber;
    }

    public UdmPatient getPatient() {
        return patient;
    }

    public void setPatient(UdmPatient patient) {
        this.patient = patient;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }

    public Set<PrescribedMedication> getPrescribedMedications() {
        return prescribedMedications;
    }

    public void setPrescribedMedications(Set<PrescribedMedication> prescribedMedications) {
        this.prescribedMedications = prescribedMedications;
    }
}
