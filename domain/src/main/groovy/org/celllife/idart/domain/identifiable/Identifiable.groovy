package org.celllife.idart.domain.identifiable

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.SystemId

/**
 * Wrapper for an entity's set of identifiers. Has a type to identify which entity.
 */
@ToString
@EqualsAndHashCode
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
