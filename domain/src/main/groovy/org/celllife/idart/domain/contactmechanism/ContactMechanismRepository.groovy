package org.celllife.idart.domain.contactmechanism;

import org.celllife.idart.domain.clinic.Clinic;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
public interface ContactMechanismRepository {

    List<Clinic> findByIdentifier(String identifierValue);

    Clinic findOneByIdentifier(String identifierSystem, String identifierValue);
}
