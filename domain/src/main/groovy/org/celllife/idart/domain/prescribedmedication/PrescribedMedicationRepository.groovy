package org.celllife.idart.domain.prescribedmedication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationRepository {

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    public <S extends PrescribedMedication> Iterable<S> save(Iterable<S> prescribedMedications)

    PrescribedMedication findOne(Long pk)

    Iterable<PrescribedMedication> findAll()

    PrescribedMedication findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<PrescribedMedication> findByIdentifier(String identifierValue)
}
