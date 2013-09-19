package org.celllife.idart.infrastructure.springdata.prescription;

import org.celllife.idart.common.PrescribedMedicationId;
import org.celllife.idart.common.PrescriptionId;
import org.celllife.idart.domain.prescription.Prescription;
import org.celllife.idart.domain.prescription.PrescriptionRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 */
public interface SpringDataPrescriptionRepository extends PrescriptionRepository,
        PagingAndSortingRepository<Prescription, PrescriptionId> {

    @Query("select prescription.id " +
            "   from Prescription prescription " +
            "   join prescription.prescribedMedications prescribedMedication " +
            "   where prescribedMedication = :prescribedMedication")
    PrescriptionId findByPrescribedMedication(@Param("prescribedMedication") PrescribedMedicationId prescribedMedication);

}
