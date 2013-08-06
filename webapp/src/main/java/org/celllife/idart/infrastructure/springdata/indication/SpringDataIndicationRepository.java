package org.celllife.idart.infrastructure.springdata.indication;

import org.celllife.idart.domain.indication.Indication;
import org.celllife.idart.domain.indication.IndicationCode;
import org.celllife.idart.domain.indication.IndicationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataIndicationRepository extends PagingAndSortingRepository<Indication, IndicationCode>, IndicationRepository {

}
