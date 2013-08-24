package org.celllife.idart.infrastructure.springdata.substitution;

import org.celllife.idart.common.SubstitutionCode;
import org.celllife.idart.domain.substitution.Substitution;
import org.celllife.idart.domain.substitution.SubstitutionRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSubstitutionRepository extends SubstitutionRepository,
        PagingAndSortingRepository<Substitution, SubstitutionCode> {

}