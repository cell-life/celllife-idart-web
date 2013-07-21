package org.celllife.idart.domain.part;

import org.celllife.idart.domain.common.Identifier;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RawMaterialService {

    RawMaterial save(RawMaterial rawMaterial);

    Iterable<RawMaterial> findAll();

    RawMaterial findByIdentifier(String identifier);

    RawMaterial findByIdentifiers(Set<Identifier> identifiers);


}