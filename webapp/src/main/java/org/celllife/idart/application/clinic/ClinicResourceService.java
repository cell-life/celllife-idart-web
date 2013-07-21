package org.celllife.idart.application.clinic;

import org.celllife.idart.domain.clinic.Clinic;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicResourceService {

    Clinic save(Clinic clinic);

    Clinic findByIdentifier(String identifier);

    Iterable<Clinic> findAll();

}