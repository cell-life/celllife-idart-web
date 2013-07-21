package org.celllife.idart.domain.clinic;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ClinicRepository {

    Clinic findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<Clinic> findByIdentifier(String identifierValue);
}
