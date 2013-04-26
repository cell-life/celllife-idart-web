package org.celllife.idart.domain.clinic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
public interface ClinicIdentifierRepository extends CrudRepository<ClinicIdentifier, Long> {
}
