package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationService {

    Medication save(Medication medication) throws MedicationValidationException

    Medication findByProductId(ProductId productId) throws MedicationNotFoundException

}
