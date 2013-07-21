package org.celllife.idart.domain.person;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 04h39
 */
public interface PersonRepository {

    Person findOneByIdentifier(String identifierSystem, String identifierValue);

}
