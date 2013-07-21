package org.celllife.idart.domain.person;


/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 12h47
 */
public interface PersonRepository {

    Person findOneByIdentifier(String identifierSystem,
                               String identifierValue);

}
