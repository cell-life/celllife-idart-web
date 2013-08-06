package org.celllife.idart.application.drug;

import org.celllife.idart.domain.drug.Drug;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugResourceService {

    Drug save(Drug drug);

    Drug findByIdentifier(String identifier);

    Iterable<Drug> findAll();

}