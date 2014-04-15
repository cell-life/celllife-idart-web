package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.PrescriptionId


/**
 */
public interface PrescriptionService {

    Boolean exists(PrescriptionId prescriptionId)

    Prescription save(Prescription prescription)

    Prescription findByPrescriptionId(PrescriptionId prescriptionId)

    PrescriptionId findByPrescribedMedication(PrescribedMedicationId prescribedMedication)
	
	Prescription deleteByPrescriptionId(PrescriptionId prescriptionId)
}
