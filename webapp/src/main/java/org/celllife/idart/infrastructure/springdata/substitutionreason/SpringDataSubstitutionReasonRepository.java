package org.celllife.idart.infrastructure.springdata.substitutionreason;

import org.celllife.idart.domain.substitutionreason.SubstitutionReason;
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonCode;
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSubstitutionReasonRepository extends PagingAndSortingRepository<SubstitutionReason, SubstitutionReasonCode>, SubstitutionReasonRepository {

}
