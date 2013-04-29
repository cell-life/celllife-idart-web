package org.celllife.idart.domain.patient;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
public enum PatientIdentifierType {

    PGWC("PGWC Patient Number"),

    PREHMIS("PREHMIS ID"),

    SAID("National ID Number"),

    PASSPORT("Passport Number"),

    IDART("iDART Patient Number");

    private String description;

    PatientIdentifierType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
