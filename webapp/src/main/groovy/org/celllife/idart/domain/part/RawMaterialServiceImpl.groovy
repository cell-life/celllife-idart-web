package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
@Service class RawMaterialServiceImpl implements RawMaterialService {

    @Autowired RawMaterialRepository rawMaterialRepository

    @Override
    RawMaterial save(RawMaterial rawMaterial) {

        RawMaterial existingRawMaterial = findByIdentifiers(rawMaterial.identifiers)
        if (existingRawMaterial == null) {
            existingRawMaterial = new RawMaterial()
        }

        existingRawMaterial.merge(rawMaterial)

        return rawMaterialRepository.save(existingRawMaterial)
    }


    RawMaterial findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def rawMaterial = rawMaterialRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (rawMaterial != null) {
                return rawMaterial
            }
        }

        null
    }
}
