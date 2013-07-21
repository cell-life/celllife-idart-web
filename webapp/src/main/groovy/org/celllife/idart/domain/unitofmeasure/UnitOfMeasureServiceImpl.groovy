package org.celllife.idart.domain.unitofmeasure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired UnitOfMeasureRepository unitOfMeasureRepository

    @Override
    Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitsOfMeasure) {
        unitsOfMeasure.collect { unitOfMeasure -> (save(unitOfMeasure)) }
    }

    @Override
    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {

        String system = unitOfMeasure.getFirstSystem()
        String code = unitOfMeasure.getCodeValue(system)

        UnitOfMeasure savedUnitOfMeasure = unitOfMeasureRepository.findOneByCode(system, code)

        if (savedUnitOfMeasure != null) {
            savedUnitOfMeasure.mergeCodes(unitOfMeasure)
            return unitOfMeasureRepository.save(savedUnitOfMeasure)
        } else {
            return unitOfMeasureRepository.save(unitOfMeasure)
        }
    }              
    
    @Override
    Iterable<UnitOfMeasure> findAll() {
        unitOfMeasureRepository.findAll()
    }

    @Override
    UnitOfMeasure findByIdentifier(String identifier) {
        null
    }
}