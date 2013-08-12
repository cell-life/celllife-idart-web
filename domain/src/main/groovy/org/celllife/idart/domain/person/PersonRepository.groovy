package org.celllife.idart.domain.person

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonRepository {

    Person save(Person person)

    Person findOne(PartyIdentifier partyIdentifier)

}
