package org.celllife.idart.application.compound;

import org.celllife.idart.domain.compound.Compound;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundResourceService {

    Compound save(Compound compound);

    Compound findByIdentifier(String identifier);

    Iterable<Compound> findAll();

}