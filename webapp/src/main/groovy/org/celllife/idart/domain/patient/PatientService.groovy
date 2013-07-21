package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
interface PatientService {

    Patient findByIdentifiers(Set<Identifier> identifiers)

    Patient save(Patient patient)

    Patient findByIdentifier(String identifier)

    Iterable<Patient> findAll()
}