package org.celllife.idart.domain.patient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
public interface PatientIdentifierRepository extends CrudRepository<PatientIdentifier, Long> {
}
