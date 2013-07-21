package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartRepository {

    // Part save(Part part);

    // Iterable<Part> save(Iterable<Part> parts);

    // Part findOne(Long pk);

    // Iterable<Part> findAll();

    Part findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<Part> findByIdentifier(String identifierValue);
}