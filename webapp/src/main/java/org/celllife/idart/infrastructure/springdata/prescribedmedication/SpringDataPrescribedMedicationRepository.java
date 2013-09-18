package org.celllife.idart.infrastructure.springdata.prescribedmedication;

import org.celllife.idart.common.PrescribedMedicationId;
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication;
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataPrescribedMedicationRepository extends PrescribedMedicationRepository,
        PagingAndSortingRepository<PrescribedMedication, PrescribedMedicationId> {

}
