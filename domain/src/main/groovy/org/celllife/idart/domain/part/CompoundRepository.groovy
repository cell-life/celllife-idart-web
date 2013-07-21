package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundRepository {

    // Compound save(Compound compound);

    // Iterable<Compound> save(Iterable<Compound> compounds);

    // Compound findOne(Long pk);

    // Iterable<Compound> findAll();

    Compound findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<Compound> findByIdentifier(String identifierValue);
}
