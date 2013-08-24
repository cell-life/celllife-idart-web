package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.common.PartId;
import org.celllife.idart.domain.part.Part;
import org.celllife.idart.domain.part.PartRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPartRepository extends PartRepository,
        PagingAndSortingRepository<Part, PartId> {

}
