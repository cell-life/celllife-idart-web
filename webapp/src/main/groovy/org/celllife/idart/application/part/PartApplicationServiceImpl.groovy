package org.celllife.idart.application.part

import org.celllife.idart.application.compound.CompoundApplicationService
import org.celllife.idart.application.drug.DrugApplicationService
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

    @Autowired CompoundApplicationService compoundApplicationService

    @Autowired DrugApplicationService drugApplicationService

    @Override
    Part save(Part part) {

        switch (part) {
            case Drug:
                return drugApplicationService.save(part as Drug)
            case Compound:
                return compoundApplicationService.save(part as Compound)
            default:
                throw UnsupportedPartException();
        }
    }
}
