package org.celllife.idart.infrastructure.springdata.prescribedmedication;

import org.celllife.idart.common.PrescribedMedicationIdentifier;
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication;
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPrescribedMedicationRepository extends PagingAndSortingRepository<PrescribedMedication, PrescribedMedicationIdentifier>, PrescribedMedicationRepository {

}