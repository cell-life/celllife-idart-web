package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RawMaterialRepository {

    RawMaterial findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<RawMaterial> findByIdentifier(String identifierValue);
}
