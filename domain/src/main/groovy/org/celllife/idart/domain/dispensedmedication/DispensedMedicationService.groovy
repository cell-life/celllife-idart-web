package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationService {

    DispensedMedication save(DispensedMedication dispensedMedication)

    Iterable<DispensedMedication> findAll()

    DispensedMedication findByIdentifier(String identifier)

    DispensedMedication findByIdentifiers(Iterable<Identifier> identifiers)

}