package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RawMaterialRepository {

    RawMaterial save(RawMaterial rawMaterial)

    public <S extends RawMaterial> Iterable<S> save(Iterable<S> rawMaterials)

    RawMaterial findOne(Long pk)

    Iterable<RawMaterial> findAll()

    RawMaterial findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<RawMaterial> findByIdentifier(String identifierValue)
}
