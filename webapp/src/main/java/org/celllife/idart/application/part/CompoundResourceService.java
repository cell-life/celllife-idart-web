package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.Compound;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundResourceService {

    Compound save(Compound compound);

    Compound findByIdentifier(String identifier);

    Iterable<Compound> findAll();

}