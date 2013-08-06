package org.celllife.idart.domain.medication

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationService {

    Medication save(Medication medication)

    Iterable<Medication> findAll()

    Medication findByIdentifier(String identifier)

    Medication findByIdentifiers(Iterable<Identifier> identifiers)

}