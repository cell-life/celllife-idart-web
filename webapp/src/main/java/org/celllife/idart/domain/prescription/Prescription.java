package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Identifiable;
import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.practitioner.Practitioner;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h49
 */
public final class Prescription implements Persistable, Identifiable, Serializable {

    /**
     * Prescribed by
     */
    private Practitioner prescriber;

    /**
     * Prescribed to
     */
    private Patient patient;

    /**
     * Written on
     */
    private Date dateWritten;

    /**
     * During
     */
//    private Visit visit;

    /**
     * Contains
     */
    private Set<PrescribedMedication> prescribedMedications;

    public Prescription() {
    }

}
