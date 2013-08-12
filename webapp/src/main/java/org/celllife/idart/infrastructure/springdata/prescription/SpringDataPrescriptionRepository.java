package org.celllife.idart.infrastructure.springdata.prescription;

import org.celllife.idart.common.PrescriptionIdentifier;
import org.celllife.idart.domain.prescription.Prescription;
import org.celllife.idart.domain.prescription.PrescriptionRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPrescriptionRepository extends PagingAndSortingRepository<Prescription, PrescriptionIdentifier>, PrescriptionRepository {

}