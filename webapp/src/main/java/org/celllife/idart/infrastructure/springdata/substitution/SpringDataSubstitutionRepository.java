package org.celllife.idart.infrastructure.springdata.substitution;

import org.celllife.idart.domain.substitution.Substitution;
import org.celllife.idart.domain.substitution.SubstitutionCode;
import org.celllife.idart.domain.substitution.SubstitutionRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSubstitutionRepository extends PagingAndSortingRepository<Substitution, SubstitutionCode>, SubstitutionRepository {

}
