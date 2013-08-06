package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationService {

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    Iterable<PrescribedMedication> findAll()

    PrescribedMedication findByIdentifier(String identifier)

    PrescribedMedication findByIdentifiers(Iterable<Identifier> identifiers)

}