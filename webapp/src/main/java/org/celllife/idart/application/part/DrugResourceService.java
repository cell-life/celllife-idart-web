package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.Drug;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugResourceService {

    Drug save(Drug drug);

    Drug findByIdentifier(String identifier);

    Iterable<Drug> findAll();

}