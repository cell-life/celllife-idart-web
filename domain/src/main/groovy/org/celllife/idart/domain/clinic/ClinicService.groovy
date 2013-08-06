package org.celllife.idart.domain.clinic

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicService {

    Clinic save(Clinic clinic)

    Iterable<Clinic> findAll()

    Clinic findByIdentifier(String identifier)

    Clinic findByIdentifiers(Iterable<Identifier> identifiers)

}