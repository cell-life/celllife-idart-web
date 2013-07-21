package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class RawMaterialServiceImpl implements RawMaterialService {

    @Autowired RawMaterialRepository rawMaterialRepository

    @Override
    RawMaterial save(RawMaterial rawMaterial) {

        RawMaterial existingRawMaterial = findByIdentifiers(rawMaterial.identifiers)
        if (existingRawMaterial == null) {
            existingRawMaterial = rawMaterial.class.newInstance()
        }

        existingRawMaterial.merge(rawMaterial)

        rawMaterialRepository.save(existingRawMaterial)
    }


    @Override
    Iterable<RawMaterial> findAll() {
        rawMaterialRepository.findAll()
    }

    @Override
    RawMaterial findByIdentifier(String identifier) {
        null
    }

    @Override
    RawMaterial findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            RawMaterial rawMaterial = rawMaterialRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (rawMaterial != null) {
                return rawMaterial
            }
        }

        null
    }
}