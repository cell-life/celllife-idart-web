package org.celllife.idart.application.part

import org.celllife.idart.domain.form.FormService
import org.celllife.idart.domain.part.FinishedGood
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 11h33
 */
@Service
@Mixin(FinishedGoodApplicationServiceMixin)
class FinishedGoodApplicationServiceImpl implements FinishedGoodApplicationService, FinishedGoodResourceService {

    @Autowired PartApplicationService partApplicationService

    @Autowired FinishedGoodService finishedGoodService

    @Autowired FormService formService

    @Autowired UnitOfMeasureService unitOfMeasureService

    FinishedGood save(FinishedGood finishedGood) {

        finishedGood?.with {

            unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)

            form = formService.findByCodes(form?.codes)

            billOfMaterials?.each { billOfMaterial ->

                billOfMaterial?.with {
                    quantityUsed?.with {
                        unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                    }

                    part = partApplicationService.findByIdentifiers(part?.identifiers)
                }

            }
        }

        finishedGoodService.save(finishedGood)
    }

    FinishedGood findByIdentifier(String identifier) {
        finishedGoodService.findByIdentifier(identifier)
    }

    Iterable<FinishedGood> findAll() {
        finishedGoodService.findAll()
    }

}