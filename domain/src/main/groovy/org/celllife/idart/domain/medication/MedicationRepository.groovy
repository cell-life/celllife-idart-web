package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationRepository {

    Medication save(Medication medication)

    Medication findOne(ProductIdentifier productIdentifier)

}
