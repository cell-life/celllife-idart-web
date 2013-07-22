package org.celllife.idart.application.druggroup

import org.celllife.idart.domain.druggroup.DrugGroup
import org.celllife.idart.domain.druggroup.DrugGroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(DrugGroupApplicationServiceMixin)
class DrugGroupApplicationServiceImpl implements DrugGroupApplicationService, DrugGroupResourceService {

    @Autowired DrugGroupService drugGroupService

    DrugGroup save(DrugGroup drugGroup) {
        drugGroupService.save(drugGroup)
    }

    DrugGroup findByIdentifier(String identifier) {
        drugGroupService.findByIdentifier(identifier)
    }

    Iterable<DrugGroup> findAll() {
        drugGroupService.findAll()
    }

}