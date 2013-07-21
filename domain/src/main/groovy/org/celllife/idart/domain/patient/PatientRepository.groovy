package org.celllife.idart.domain.patient;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientRepository {

    Patient save(Patient patient)

    public <S extends Patient> Iterable<S> save(Iterable<S> patients)

    Patient findOne(Long pk)

    Iterable<Patient> findAll()

    Patient findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Patient> findByIdentifier(String identifierValue)
}
