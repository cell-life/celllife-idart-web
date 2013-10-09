package org.celllife.idart.application.prescription

import org.celllife.idart.domain.prescription.Prescription

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
interface PrescriptionProvider {

    void save(Prescription prescription)

}
