package org.celllife.idart.application.part

import org.celllife.idart.domain.part.RawMaterial
import org.celllife.idart.domain.part.RawMaterialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Service
@Mixin(RawMaterialApplicationServiceMixin)
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RawMaterialApplicationServiceImpl implements RawMaterialApplicationService, RawMaterialResourceService {

    @Autowired RawMaterialService rawMaterialService

    RawMaterial save(RawMaterial rawMaterial) {
        rawMaterialService.save(rawMaterial)
    }

    RawMaterial findByIdentifier(String identifier) {
        rawMaterialService.findByIdentifier(identifier)
    }

    Iterable<RawMaterial> findAll() {
        rawMaterialService.findAll()
    }

}