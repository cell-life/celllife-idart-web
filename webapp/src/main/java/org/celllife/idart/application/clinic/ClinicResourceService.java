package org.celllife.idart.application.clinic;

import org.celllife.idart.domain.clinic.Clinic;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicResourceService {

    Clinic save(Clinic clinic);

    Clinic findByIdentifier(String identifier);

    Iterable<Clinic> findAll();

}