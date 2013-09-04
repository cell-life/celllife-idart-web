package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.AuthorityId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h34
 */
class Identifiable {

    Long pk

    IdentifiableType type

    Set<Identifier> identifiers = [] as Set

    static Identifiable newIdentifiable(IdentifiableType type) {
        new Identifiable(type: type)
    }

    def getIdentifier(AuthorityId authorityId) {

        for (identifier in identifiers) {
            if (identifier.authority.equals(authorityId)) {
                return identifier
            }
        }

        null
    }

    def addIdentifiers(Set<Identifier> identifiers) {
        this.identifiers.addAll(identifiers)
    }

    def addIdentifier(Identifier identifier) {
        this.identifiers.add(identifier)
    }
}
