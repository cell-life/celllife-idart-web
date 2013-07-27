package org.celllife.idart.application.compound

import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.compound.CompoundService
import org.celllife.idart.domain.form.FormService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service class CompoundApplicationServiceImpl implements CompoundApplicationService, CompoundResourceService {

    @Autowired CompoundService compoundService

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired FormService formService

    Compound save(Compound compound) {

        compound?.with {

            unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)

            form = formService.findByCodes(form?.codes)

        }

        compoundService.save(compound)
    }

    Compound findByIdentifier(String identifier) {
        compoundService.findByIdentifier(identifier)
    }

    Iterable<Compound> findAll() {
        compoundService.findAll()
    }

}