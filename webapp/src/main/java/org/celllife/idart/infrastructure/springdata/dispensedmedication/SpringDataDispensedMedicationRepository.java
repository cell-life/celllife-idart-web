package org.celllife.idart.infrastructure.springdata.dispensedmedication;

import org.celllife.idart.common.DispensedMedicationIdentifier;
import org.celllife.idart.domain.dispensedmedication.DispensedMedication;
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDispensedMedicationRepository extends PagingAndSortingRepository<DispensedMedication, DispensedMedicationIdentifier>, DispensedMedicationRepository {

}