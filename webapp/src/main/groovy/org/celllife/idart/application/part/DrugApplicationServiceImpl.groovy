package org.celllife.idart.application.part

import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.DrugService
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

    @Override
    Drug save(Drug drug) {

        drug.billOfMaterials.each { billOfMaterial ->
            billOfMaterial.part = partApplicationService.findByIdentifiers(billOfMaterial.part.identifiers)
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
