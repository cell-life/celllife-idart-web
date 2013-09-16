package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier

import static org.celllife.idart.common.Identifiers.getIdentifierValue

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h34
 */
class Identifiable implements Serializable {

    Long pk

    IdentifiableType type

    Set<Identifier> identifiers = [] as Set

    static Identifiable newIdentifiable(IdentifiableType type) {
        new Identifiable(type: type)
    }

    def getIdentifierValue(SystemId systemId) {
        getIdentifierValue(identifiers, systemId)
    }

    def addIdentifiers(Set<Identifier> identifiers) {
        this.identifiers.addAll(identifiers)
    }

    def addIdentifier(Identifier identifier) {
        this.identifiers.add(identifier)
    }
}
