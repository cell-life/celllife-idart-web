package org.celllife.idart.domain.prescription

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h49
 */
@Service class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired PrescriptionRepository prescriptionRepository

    @Override
    def save(Prescription prescription) {
        prescriptionRepository.save(prescription)
    }

}
