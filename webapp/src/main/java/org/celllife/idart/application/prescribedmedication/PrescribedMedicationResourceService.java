package org.celllife.idart.application.prescribedmedication;

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationResourceService {

    PrescribedMedication save(PrescribedMedication prescribedMedication);

    PrescribedMedication findByIdentifier(String identifier);

    Iterable<PrescribedMedication> findAll();

}