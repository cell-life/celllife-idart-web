package org.celllife.idart.infrastructure.springdata.medication;

import org.celllife.idart.common.ProductId;
import org.celllife.idart.domain.medication.Medication;
import org.celllife.idart.domain.medication.MedicationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataMedicationRepository extends MedicationRepository,
        PagingAndSortingRepository<Medication, ProductId> {

}
