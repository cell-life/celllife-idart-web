package org.celllife.idart.infrastructure.springdata.drug;

import org.celllife.idart.common.PartIdentifier;
import org.celllife.idart.domain.drug.Drug;
import org.celllife.idart.domain.drug.DrugRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDrugRepository extends DrugRepository,
        PagingAndSortingRepository<Drug, PartIdentifier> {

}