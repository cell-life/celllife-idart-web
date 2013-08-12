package org.celllife.idart.infrastructure.springdata.compound;

import org.celllife.idart.common.PartIdentifier;
import org.celllife.idart.domain.compound.Compound;
import org.celllife.idart.domain.compound.CompoundRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataCompoundRepository extends PagingAndSortingRepository<Compound, PartIdentifier>, CompoundRepository {

}