package org.celllife.idart.infrastructure.springdata.substitutionreason;

import org.celllife.idart.common.SubstitutionReasonCode;
import org.celllife.idart.domain.substitutionreason.SubstitutionReason;
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSubstitutionReasonRepository extends SubstitutionReasonRepository,
        PagingAndSortingRepository<SubstitutionReason, SubstitutionReasonCode> {

}