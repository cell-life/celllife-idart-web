package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.partyrole.PartyRole

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h06
 */
class Practitioners {

    static final String IDART_PRACTITIONER_IDENTIFIER_FORMAT = "%08d"

    static requiresIdartIdentifier(Practitioner... practitioners) {

        for (Practitioner practitioner in practitioners) {
            if (((PartyRole) practitioner)?.hasIdentifierForSystem(Practitioner.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
