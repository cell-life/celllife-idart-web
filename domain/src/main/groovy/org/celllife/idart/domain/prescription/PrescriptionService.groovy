package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionService {

    Prescription save(Prescription prescription)

    Iterable<Prescription> findAll()

    Prescription findByIdentifier(String identifier)

    Prescription findByIdentifiers(Iterable<Identifier> identifiers)

}