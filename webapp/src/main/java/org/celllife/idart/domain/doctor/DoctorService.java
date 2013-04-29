package org.celllife.idart.domain.doctor;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h46
 */
public interface DoctorService {

    Doctor findByIdentifiers(Set<DoctorIdentifier> identifiers);

}
