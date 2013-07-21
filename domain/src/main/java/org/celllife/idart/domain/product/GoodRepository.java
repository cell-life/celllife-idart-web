package org.celllife.idart.domain.product;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface GoodRepository {

    Good findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<Good> findByIdentifier(String identifierValue);
}
