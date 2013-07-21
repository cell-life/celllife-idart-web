package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h49
 */
interface PrescriptionService {

    Prescription save(Prescription prescription)

    Prescription findByIdentifier(String identifier)

    Prescription findByIdentifiers(Set<Identifier> identifiers)

    Iterable<Prescription> findAll()

}