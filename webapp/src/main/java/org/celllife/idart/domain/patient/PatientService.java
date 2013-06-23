package org.celllife.idart.domain.patient;

import org.celllife.idart.domain.concept.Identifier;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
public interface PatientService {

    Patient findByIdentifiers(Set<Identifier> identifiers);

    void save(Patient patient);
}
