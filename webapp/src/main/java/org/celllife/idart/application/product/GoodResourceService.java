package org.celllife.idart.application.product;

import org.celllife.idart.domain.product.Good;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface GoodResourceService {

    Good save(Good good);

    Good findByIdentifier(String identifier);

    Iterable<Good> findAll();

}