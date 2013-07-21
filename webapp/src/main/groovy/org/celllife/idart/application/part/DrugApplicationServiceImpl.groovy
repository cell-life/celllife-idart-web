package org.celllife.idart.application.part

import org.celllife.idart.domain.form.FormService
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.DrugService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h33
 */
@Service class DrugApplicationServiceImpl implements DrugApplicationService, DrugResourceService {

    @Autowired DrugService drugService

    @Autowired PartApplicationService partApplicationService

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Autowired FormService formService

    @Override
    Drug save(Drug drug) {

        drug?.with {

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

        drugService.save(drug)
    }

    @Override
    Drug findByIdentifier(String identifier) {
        drugService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Drug> findAll() {
        return drugService.findAll()
    }
}
