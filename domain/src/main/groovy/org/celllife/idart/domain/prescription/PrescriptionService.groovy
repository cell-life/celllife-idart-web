package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionService {

    Prescription save(Prescription prescription)

    Iterable<Prescription> findAll()

    Prescription findByIdentifier(String identifier)

    Prescription findByIdentifiers(Iterable<Identifier> identifiers)

}