package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugGroupRepository {

    // DrugGroup save(DrugGroup drugGroup);

    // Iterable<DrugGroup> save(Iterable<DrugGroup> drugGroups);

    // DrugGroup findOne(Long pk);

    // Iterable<DrugGroup> findAll();

    DrugGroup findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<DrugGroup> findByIdentifier(String identifierValue);
}
