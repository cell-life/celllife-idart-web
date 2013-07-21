package org.celllife.idart.domain.prescription

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.practitioner.Practitioner

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
    @JsonIgnore Long pk

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

}
