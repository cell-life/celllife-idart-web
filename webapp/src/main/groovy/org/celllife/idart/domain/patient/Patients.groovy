package org.celllife.idart.domain.patient

import org.celllife.idart.domain.partyrole.PartyRole

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h06
 */
class Patients {

    static final String IDART_PATIENT_IDENTIFIER_SYSTEM = "http://www.cell-life.org/idart/patient"

    static final String IDART_PATIENT_IDENTIFIER_FORMAT = "%08d"

    static requiresIdartIdentifier(Patient... patients) {

        for (Patient patient in patients) {
            if (((PartyRole) patient)?.hasIdentifierForSystem(IDART_PATIENT_IDENTIFIER_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
