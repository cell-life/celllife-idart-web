package org.celllife.idart.domain.prescription;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionRepository {

    Prescription save(Prescription prescription)

    public <S extends Prescription> Iterable<S> save(Iterable<S> prescriptions)

    Prescription findOne(Long pk)

    Iterable<Prescription> findAll()

    Prescription findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Prescription> findByIdentifier(String identifierValue)
}
