package org.celllife.idart.application.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.RawMaterialService
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h24
 */
@Service class PartApplicationServiceImpl implements PartApplicationService, PartResourceService, InitializingBean {

    @Autowired FinishedGoodService finishedGoodService

    @Autowired RawMaterialService rawMaterialService

    def partServices

    @Override
    Part findByIdentifiers(Set<Identifier> identifiers) {

        for (partService in partServices) {
            def part = partService.findByIdentifiers(identifiers)
            if (part != null) {
                return part;
            }
        }

        return null
    }

    @Override
    Part save(Part part) {
        return null
    }

    @Override
    Part findByIdentifier(String identifier) {
        return null
    }

    @Override
    Iterable<Part> findAll() {
        return null
    }

    @Override
    void afterPropertiesSet() throws Exception {
        this.partServices = [finishedGoodService, rawMaterialService]
    }
}
