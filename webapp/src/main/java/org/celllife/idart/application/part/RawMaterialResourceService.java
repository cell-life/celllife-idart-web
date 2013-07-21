package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.RawMaterial;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RawMaterialResourceService {

    RawMaterial save(RawMaterial rawMaterial);

    RawMaterial findByIdentifier(String identifier);

    Iterable<RawMaterial> findAll();

}