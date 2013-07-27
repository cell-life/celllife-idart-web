package org.celllife.idart.domain.common
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class Codeable {

    void addCode(String system, String value) {
        if (this.codes == null) {
            this.codes = new HashSet<>()
        }

        this.codes.add(new Code(system: system, value: value))
    }


    String getIdartCodeValue() {
        getCodeValue(IDART_SYSTEM)
    }


    String getDefaultCodeValue() {
        getCodeValue(DEFAULT_SYSTEM)
    }

    String getFirstSystem() {

        if (this.codes == null || this.codes.empty) {
            return null
        }

        this.codes.find().system
    }

    String getCodeValue(String system) {

        if (system == null) {
            return null
        }

        this.codes.find({ code -> code.system.equals(system) })?.value
    }

    Set<String> getCodeSystems() {
        this.codes*.system
    }

    void mergeCodes(that) {

        if (!this.class.isAssignableFrom(that.class)) {
            throw new RuntimeException("Incompatible CodedConcept Types: this ${this.class} that ${that.class}")
        }

        that.codeSystems.each { system -> this.addCode(system, that.getCodeValue(system)) }
    }
}
