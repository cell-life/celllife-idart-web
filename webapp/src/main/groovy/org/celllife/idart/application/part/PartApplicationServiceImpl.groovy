package org.celllife.idart.application.part

import org.celllife.idart.application.compound.CompoundResourceService
import org.celllife.idart.application.drug.DrugResourceService
import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.part.Part
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h24
 */
@Service class PartApplicationServiceImpl implements PartApplicationService {

    @Autowired CompoundResourceService compoundResourceService

    @Autowired DrugResourceService drugResourceService

    @Override
    Part save(Part part) {

        switch (part) {
            case Drug:
                return drugResourceService.save(part as Drug)
            case Compound:
                return compoundResourceService.save(part as Compound)
            default:
                throw UnsupportedPartException();
        }
    }
}
