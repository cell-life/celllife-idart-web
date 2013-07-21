package org.celllife.idart.domain.clinic;

import org.celllife.idart.domain.common.Identifier;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicService {

    Clinic save(Clinic clinic);

    Iterable<Clinic> findAll();

    Clinic findByIdentifier(String identifier);

    Clinic findByIdentifiers(Set<Identifier> identifiers);


}