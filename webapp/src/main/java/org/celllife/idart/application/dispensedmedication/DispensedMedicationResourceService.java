package org.celllife.idart.application.dispensedmedication;

import org.celllife.idart.domain.dispensedmedication.DispensedMedication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationResourceService {

    DispensedMedication save(DispensedMedication dispensedMedication);

    DispensedMedication findByIdentifier(String identifier);

    Iterable<DispensedMedication> findAll();

}