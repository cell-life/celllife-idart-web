package org.celllife.idart.application.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.part.Subassembly
import org.celllife.idart.domain.part.SubassemblyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h48
 */
@Service
@Mixin(SubassemblyApplicationServiceMixin)
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubassemblyApplicationServiceImpl implements SubassemblyApplicationService, SubassemblyResourceService {

    @Autowired SubassemblyService subassemblyService

    Subassembly save(Subassembly subassembly) {
        subassemblyService.save(subassembly)
    }

    Subassembly findByIdentifier(String identifier) {
        subassemblyService.findByIdentifier(identifier)
    }

    Iterable<Subassembly> findAll() {
        subassemblyService.findAll()
    }

}