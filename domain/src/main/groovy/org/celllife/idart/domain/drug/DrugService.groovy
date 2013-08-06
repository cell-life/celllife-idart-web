package org.celllife.idart.domain.drug

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugService {

    Drug save(Drug drug)

    Iterable<Drug> findAll()

    Drug findByIdentifier(String identifier)

    Drug findByIdentifiers(Iterable<Identifier> identifiers)

}