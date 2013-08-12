package org.celllife.idart.domain.person

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonService {

    Person save(Person person) throws PersonValidationException

    Person findByPartyIdentifier(PartyIdentifier partyIdentifier) throws PersonNotFoundException

}