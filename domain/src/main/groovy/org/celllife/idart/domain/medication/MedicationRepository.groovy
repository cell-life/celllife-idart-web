package org.celllife.idart.domain.medication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationRepository {

    Medication save(Medication medication)

    public <S extends Medication> Iterable<S> save(Iterable<S> medications)

    Medication findOne(Long pk)

    Iterable<Medication> findAll()

    Medication findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Medication> findByIdentifier(String identifierValue)
}
