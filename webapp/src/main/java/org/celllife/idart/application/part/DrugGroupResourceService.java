package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.DrugGroup;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugGroupResourceService {

    DrugGroup save(DrugGroup drugGroup);

    DrugGroup findByIdentifier(String identifier);

    Iterable<DrugGroup> findAll();

}