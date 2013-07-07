package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.Identifier
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.practitioner.Practitioner

import static org.celllife.idart.framework.aspectj.InjectIdentified.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h49
 */
@Mixin([Identifiable])
class Prescription implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Prescribed by
     */
    Practitioner prescriber

    /**
     * Prescribed to
     */
    Patient patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
//     Visit visit

    /**
     * Contains
     */
    Set<PrescribedMedication> prescribedMedications

    void setPrescriber(Practitioner prescriber) {
        this.prescriber = inject(prescriber)
    }

    void setPatient(Patient patient) {
        this.patient = inject(patient)
    }
}
