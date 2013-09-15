package org.celllife.idart.application.prescription.dto

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.identifiable.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h34
 */
class PrescriptionDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Prescribed by
     */
    PractitionerDto prescriber

    /**
     * Prescribed to
     */
    PatientDto patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
    EncounterId encounter

    /**
     * Contains
     */
    Set<PrescribedMedicationDto> prescribedMedications = [] as Set

}
