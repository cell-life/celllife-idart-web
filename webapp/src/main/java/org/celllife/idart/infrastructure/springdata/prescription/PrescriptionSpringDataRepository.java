package org.celllife.idart.domain.prescription;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h12
 */
@RestResource(path = "prescriptions")
public interface PrescriptionSpringDataRepository extends PrescriptionRepository,  PagingAndSortingRepository<Prescription, Long> {
}
