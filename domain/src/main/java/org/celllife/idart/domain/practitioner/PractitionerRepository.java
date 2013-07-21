package org.celllife.idart.domain.practitioner;


/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
public interface PractitionerRepository {

    Practitioner findOneByIdentifier(String identifierSystem, String identifierValue);

}
