package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(UnitOfMeasureApplicationServiceMixin)
class UnitOfMeasureApplicationServiceImpl implements UnitOfMeasureApplicationService, UnitOfMeasureResourceService {

    @Autowired UnitOfMeasureService unitOfMeasureService

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        unitOfMeasureService.save(unitOfMeasure)
    }

    UnitOfMeasure findByCode(String code) {
        unitOfMeasureService.findByIdentifier(code)
    }

    Iterable<UnitOfMeasure> findAll() {
        unitOfMeasureService.findAll()
    }

}