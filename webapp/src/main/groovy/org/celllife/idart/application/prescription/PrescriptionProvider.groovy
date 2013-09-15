package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
interface PrescriptionProvider {

    void save(String facilityCode, PrescriptionDto prescription)

}
