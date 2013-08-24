package org.celllife.idart.application.part

import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h24
 */
@Service class PartApplicationServiceImpl implements PartApplicationService {

    @Autowired PartService partService

    @Override
    Part save(Part part) {
        return partService.save(part as Compound)
    }
}
