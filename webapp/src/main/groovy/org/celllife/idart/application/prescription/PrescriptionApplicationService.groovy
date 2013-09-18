package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Identifier


/**
 */
interface PrescriptionApplicationService {

    Boolean exists(PrescriptionId prescriptionId)

    PrescriptionId save(PrescriptionDto prescriptionDto)

    PrescriptionDto findByPrescriptionId(PrescriptionId prescriptionId)

    PrescriptionDto findByIdentifier(Identifier identifier)

    PrescriptionId findByIdentifiers(Set<Identifier> identifiers)

}
