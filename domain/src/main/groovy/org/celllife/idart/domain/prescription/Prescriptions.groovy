package org.celllife.idart.domain.prescription
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h06
 */
class Prescriptions {

    static final String IDART_PRESCRIPTION_IDENTIFIER_FORMAT = "%08d"

    static requiresIdartIdentifier(Prescription... prescriptions) {

        for (Prescription prescription in prescriptions) {
            if (prescription?.hasIdentifierForSystem(Prescription.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
