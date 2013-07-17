package org.celllife.idart.application.prescription

import org.celllife.idart.domain.prescription.Prescription

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h45
 */
interface PrescriptionApplicationService {

    def save(Prescription prescription)

}