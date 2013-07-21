package org.celllife.idart.integration.prehmis

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
enum PrehmisPatientIdentifierType {

    PGWC("http://www.pgwc.gov.za", "PGWC Patient Number"),

    PREHMIS("http://prehmis.capetown.gov.za", "PREHMIS ID"),

    SAID("http://www.dha.gov.za/national", "National ID Number"),

    PASSPORT("http://www.dha.gov.za/passport", "Passport Number")

    final String system

    final String description

    PrehmisPatientIdentifierType(String system, String description) {
        this.system = system
        this.description = description
    }

    String getDescription() {
        return description
    }

    String getSystem() {
        return this.system
    }
}