package org.celllife.idart.domain.part;

import org.celllife.idart.domain.common.Identifier;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartService {

    Part save(Part part);

    Iterable<Part> findAll();

    Part findByIdentifier(String identifier);

    Part findByIdentifiers(Set<Identifier> identifiers);


}