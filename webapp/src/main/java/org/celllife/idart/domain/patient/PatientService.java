package org.celllife.idart.domain.patient;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
public interface PatientService {

    Patient findByIdentifiers(Set<PatientIdentifier> identifiers);

}
