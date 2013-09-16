package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescribedMedicationApplicationService {

    Boolean exists(PrescribedMedicationId prescribedMedicationId)

    PrescribedMedicationId save(PrescribedMedicationDto prescribedMedicationDto)

    PrescribedMedicationDto findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId)

    PrescribedMedicationDto findByIdentifier(Identifier identifier)

    PrescribedMedicationId findByIdentifiers(Set<Identifier> identifiers)

}
