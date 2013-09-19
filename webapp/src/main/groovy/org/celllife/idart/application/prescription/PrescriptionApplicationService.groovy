package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.SystemId


/**
 */
interface PrescriptionApplicationService {

    Boolean exists(PrescriptionId prescriptionId)

    PrescriptionId save(SystemId systemId, PrescriptionDto prescriptionDto)

    PrescriptionId save(PrescriptionDto prescriptionDto)

    PrescriptionDto findByPrescriptionId(PrescriptionId prescriptionId)

    PrescriptionDto findByIdentifier(Identifier identifier)

    PrescriptionId findByIdentifiers(Set<Identifier> identifiers)

}
