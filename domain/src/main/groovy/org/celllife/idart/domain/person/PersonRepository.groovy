package org.celllife.idart.domain.person

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 04h39
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonRepository {

    Person findOneByIdentifier(String identifierSystem, String identifierValue);

}
