package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationRepository {

    Medication save(Medication medication)

    Medication findOne(ProductId productId)

}