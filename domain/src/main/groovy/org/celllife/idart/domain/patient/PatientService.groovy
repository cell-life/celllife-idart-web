package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientService {

    Patient save(Patient patient)

    Iterable<Patient> findAll()

    Patient findByIdentifier(String identifier)

    Patient findByIdentifiers(Iterable<Identifier> identifiers)

}