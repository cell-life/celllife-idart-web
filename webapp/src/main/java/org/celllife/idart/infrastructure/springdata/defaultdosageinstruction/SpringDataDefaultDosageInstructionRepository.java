package org.celllife.idart.infrastructure.springdata.defaultdosageinstruction;

import org.celllife.idart.common.DefaultDosageInstructionId;
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction;
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDefaultDosageInstructionRepository extends DefaultDosageInstructionRepository,
        PagingAndSortingRepository<DefaultDosageInstruction, DefaultDosageInstructionId> {

}
