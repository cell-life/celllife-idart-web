package org.celllife.idart.domain.doctor;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
public enum DoctorIdentifierType {

    PREHMIS("PREHMIS Practioner Code"),

    IDART("iDART Doctor Code");

    private String description;

    DoctorIdentifierType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
