package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientService {

    Patient save(Patient patient)

    Iterable<Patient> findAll()

    Patient findByIdentifier(String identifier)

    Patient findByIdentifiers(Iterable<Identifier> identifiers)

}