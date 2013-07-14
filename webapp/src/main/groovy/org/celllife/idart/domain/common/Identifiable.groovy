package org.celllife.idart.domain.common
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class Identifiable {

    def addIdentifier(String system, String value) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>()
        }

        this.identifiers.add(new Identifier(system: system, value: value))
    }

    def String getFirstSystem() {

        if (this.identifiers == null || this.identifiers.empty) {
            return null
        }

        this.identifiers.find().system
    }

    def String getIdentifierValue(String system) {

        if (system == null) {
            return null
        }

        identifiers.find({ identifier -> identifier.system.equals(system) })?.value
    }

    def Set<String> getIdentifierSystems() {
        identifiers*.system
    }

    def Boolean hasIdentifierForSystem(String system) {
        getIdentifierValue(system) != null
    }

    def Boolean hasNoIdentifierForSystem(String system) {
        !hasIdentifierForSystem(system)
    }

    def mergeIdentifiers(that) {

        if (!this.class.isAssignableFrom(that.class)) {
            throw new RuntimeException("Incompatible Identifier Types: this ${this.class} that ${that.class}")
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
    }
}
