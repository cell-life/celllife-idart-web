package org.celllife.idart.domain.clinic;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
