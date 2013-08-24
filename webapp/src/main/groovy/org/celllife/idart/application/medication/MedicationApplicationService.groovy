package org.celllife.idart.application.medication

import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.medication.MedicationValidationException
import org.celllife.idart.domain.medication.MedicationNotFoundException
import org.celllife.idart.common.ProductId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface MedicationApplicationService {

    Medication save(Medication medication) throws MedicationValidationException

    Medication findByProductId(ProductId productId) throws MedicationNotFoundException

}
