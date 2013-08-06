package org.celllife.idart.domain.dispensedmedication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationRepository {

    DispensedMedication save(DispensedMedication dispensedMedication)

    public <S extends DispensedMedication> Iterable<S> save(Iterable<S> dispensedMedications)

    DispensedMedication findOne(Long pk)

    Iterable<DispensedMedication> findAll()

    DispensedMedication findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<DispensedMedication> findByIdentifier(String identifierValue)
}
