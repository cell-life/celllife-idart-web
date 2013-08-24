package org.celllife.idart.infrastructure.springdata.indication;

import org.celllife.idart.common.IndicationCode;
import org.celllife.idart.domain.indication.Indication;
import org.celllife.idart.domain.indication.IndicationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataIndicationRepository extends IndicationRepository,
        PagingAndSortingRepository<Indication, IndicationCode> {

}
