package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationService {

    Medication save(Medication medication) throws MedicationValidationException

    Medication findByProductIdentifier(ProductIdentifier productIdentifier) throws MedicationNotFoundException

}