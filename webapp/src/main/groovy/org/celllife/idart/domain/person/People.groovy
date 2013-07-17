package org.celllife.idart.domain.person

import org.celllife.idart.domain.party.Party

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h06
 */
class People {

    static final String IDART_PERSON_IDENTIFIER_SYSTEM = "http://www.cell-life.org/idart/person"

    static final String IDART_PERSON_IDENTIFIER_FORMAT = "%08d"

    /**
     *
     * Iterate through people and check if any have an iDART identifier
     *
     * @param people
     * @return
     */
    static requiresIdartIdentifier(Person... people) {

        for (Person person in people) {
            if (((Party) person)?.hasIdentifierForSystem(IDART_PERSON_IDENTIFIER_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
