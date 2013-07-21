package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.domain.common.Code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
        unitOfMeasureRepository.save(lookupAndMerge(unitOfMeasure))
    }

    def lookupAndMerge(UnitOfMeasure unitOfMeasure) {

        def (String system, String value) = getLookupCode(unitOfMeasure)

        UnitOfMeasure existingUnitOfMeasure = unitOfMeasureRepository.findOneByCode(system, value)

        if (existingUnitOfMeasure == null) {

            // Ensure that idartCodeValue is always set
            if (unitOfMeasure.idartCodeValue == null) {
                unitOfMeasure.addCode(unitOfMeasure.idartSystem, unitOfMeasure.defaultCodeValue)
            }

            return unitOfMeasure
        }

        existingUnitOfMeasure.mergeCodes(unitOfMeasure)
        existingUnitOfMeasure
    }

    static getLookupCode(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure.idartCodeValue == null && unitOfMeasure.defaultCodeValue == null) {
            throw new RuntimeException("No code for default system [${ unitOfMeasure.defaultSystem}] or idart system [${ unitOfMeasure.idartSystem}]")
        }

        if (unitOfMeasure.defaultCodeValue != null) {
            return [unitOfMeasure.defaultSystem, unitOfMeasure.defaultCodeValue]
        }

        return [unitOfMeasure.idartSystem, unitOfMeasure.idartCodeValue]
    }

    @Override
    Iterable<UnitOfMeasure> findAll() {
        unitOfMeasureRepository.findAll()
    }

    @Override
    UnitOfMeasure findByCode(String code) {
        unitOfMeasureRepository.findOneByCode(UnitOfMeasure.IDART_SYSTEM, code)
    }

    @Override
    UnitOfMeasure findByCodes(Iterable<Code> codes) {

        if (codes == null) {
            return null
        }

        for (code in codes) {
            def unitOfMeasure = unitOfMeasureRepository.findOneByCode(code.system, code.value)
            if (unitOfMeasure != null) {
                return unitOfMeasure
            }
        }

        null
    }
}