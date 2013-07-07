package org.celllife.idart.domain.common

import org.celllife.idart.domain.concept.Code

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class Codeable {

    def addCode(String system, String value) {
        if (this.codes == null) {
            this.codes = new HashSet<>()
        }

        this.codes.add(new Code(system: system, value: value))
    }

    def String getFirstSystem() {

        if (this.codes == null || this.codes.empty) {
            return null
        }

        this.codes.find().system
    }

    def String getCodeValue(String system) {

        if (system == null) {
            return null
        }

        codes.find({ code -> code.system.equals(system) }).value
    }

    def Set<String> getCodeSystems() {
        codes*.system
    }

    def mergeCodes(Codeable that) {

        if (!this.class.isAssignableFrom(that.class)) {
            throw new RuntimeException("Incompatible CodedConcept Types: this ${this.class} that ${that.class}")
        }

        that.codeSystems.each { system -> this.addCode(system, that.getCodeValue(system)) }
    }
}
