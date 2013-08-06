package org.celllife.idart.domain.clinic;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicRepository {

    Clinic save(Clinic clinic)

    public <S extends Clinic> Iterable<S> save(Iterable<S> clinics)

    Clinic findOne(Long pk)

    Iterable<Clinic> findAll()

    Clinic findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Clinic> findByIdentifier(String identifierValue)
}
