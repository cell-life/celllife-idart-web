package org.celllife.idart.application.prescription.dto

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.Identifier

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
    Set<Identifier> prescriber

    /**
     * Prescribed to
     */
    Set<Identifier> patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
    Set<Identifier> encounter

    /**
     * Contains
     */
    Set<PrescribedMedicationDto> prescribedMedications = [] as Set

}
