package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RawMaterialRepository {

    // RawMaterial save(RawMaterial rawMaterial);

    // Iterable<RawMaterial> save(Iterable<RawMaterial> rawMaterials);

    // RawMaterial findOne(Long pk);

    // Iterable<RawMaterial> findAll();

    RawMaterial findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<RawMaterial> findByIdentifier(String identifierValue);
}
