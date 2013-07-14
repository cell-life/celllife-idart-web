package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h46
 */
interface PractitionerService {

    Practitioner findByIdentifiers(Set<Identifier> identifiers)

    Practitioner save(Practitioner practitioner)
}
