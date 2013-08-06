package org.celllife.idart.application.medication;

import org.celllife.idart.domain.medication.Medication;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface MedicationResourceService {

    Medication save(Medication medication);

    Medication findByIdentifier(String identifier);

    Iterable<Medication> findAll();

}