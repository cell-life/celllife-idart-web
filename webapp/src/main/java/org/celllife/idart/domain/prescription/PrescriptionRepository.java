package org.celllife.idart.domain.prescription;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h12
 */
public interface PrescriptionRepository extends PagingAndSortingRepository<Prescription, Long> {
}
