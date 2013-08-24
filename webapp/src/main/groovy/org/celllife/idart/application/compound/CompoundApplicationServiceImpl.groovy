package org.celllife.idart.application.compound

import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.compound.CompoundValidationException
import org.celllife.idart.domain.compound.CompoundNotFoundException
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.compound.CompoundService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CompoundApplicationServiceImpl implements CompoundApplicationService {

    @Autowired CompoundService compoundService

    Compound save(Compound compound) throws CompoundValidationException {
        compoundService.save(compound)
    }

    Compound findByPartId(PartId partId) throws CompoundNotFoundException{
        compoundService.findByPartId(partId)
    }

}
