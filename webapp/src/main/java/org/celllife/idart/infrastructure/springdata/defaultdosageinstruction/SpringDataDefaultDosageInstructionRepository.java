package org.celllife.idart.infrastructure.springdata.defaultdosageinstruction;

import org.celllife.idart.common.DefaultDosageInstructionId;
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction;
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataDefaultDosageInstructionRepository extends DefaultDosageInstructionRepository,
        PagingAndSortingRepository<DefaultDosageInstruction, DefaultDosageInstructionId> {

}
