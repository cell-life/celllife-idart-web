package org.celllife.idart.infrastructure.springdata.prescription;

import org.celllife.idart.common.PrescriptionId;
import org.celllife.idart.domain.prescription.Prescription;
import org.celllife.idart.domain.prescription.PrescriptionRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataPrescriptionRepository extends PrescriptionRepository,
        PagingAndSortingRepository<Prescription, PrescriptionId> {

}
