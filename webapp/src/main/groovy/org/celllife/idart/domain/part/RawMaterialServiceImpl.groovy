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
    void save(RawMaterial rawMaterial) {

        RawMaterial existingRawMaterial = findOneByIdentifiers(rawMaterial.identifiers)
        if (existingRawMaterial == null) {
            existingRawMaterial = new RawMaterial()
        }

        merge(rawMaterial, existingRawMaterial)

        rawMaterialRepository.save(existingRawMaterial)
    }

    static merge(RawMaterial source, RawMaterial target) {
        target.mergeIdentifiers(source)
        target.unitOfMeasure = source.unitOfMeasure
        target.form = target.form
        target.mergeClassifications(source)
    }

    RawMaterial findOneByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def rawMaterial = rawMaterialRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (rawMaterial != null) {
                return rawMaterial
            }
        }

        null
    }
}
