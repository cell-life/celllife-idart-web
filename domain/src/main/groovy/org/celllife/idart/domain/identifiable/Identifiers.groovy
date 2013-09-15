package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.AuthorityId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h40
 */
class Identifiers {

    static Identifier newIdentifier(AuthorityId authority, String value) {
        new Identifier(authority: authority, value: value)
    }

    static String getIdentifierValue(Set<Identifier> identifiers, AuthorityId authorityId) {
        for (identifier in identifiers) {
            if (identifier.authority.equals(authorityId)) {
                return identifier.value
            }
        }
        return null
    }

}
