package org.celllife.idart.domain.unitofmeasure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
@Service class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired UnitOfMeasureRepository unitOfMeasureRespository

    Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitOfMeasures) {
        unitOfMeasures.collect { unitOfMeasure -> save(unitOfMeasure) }
    }

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {

        String system = unitOfMeasure.getFirstSystem()
        String code = unitOfMeasure.getCodeValue(system)

        UnitOfMeasure savedUnitOfMeasure = unitOfMeasureRespository.findOneBySystemAndCode(system, code)

        if (savedUnitOfMeasure != null) {
            savedUnitOfMeasure.mergeCodes(unitOfMeasure)
            unitOfMeasureRespository.save(savedUnitOfMeasure)
        } else {
            unitOfMeasureRespository.save(unitOfMeasure)
        }
    }
}
