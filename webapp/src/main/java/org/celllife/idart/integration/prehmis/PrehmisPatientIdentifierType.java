package org.celllife.idart.integration.prehmis;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
public enum PrehmisPatientIdentifierType {

    PGWC("pgwc"),

    PREHMIS("prehmis"),

    SAID("said");

    private String type;

    PrehmisPatientIdentifierType(String type) {

        this.type = type;
    }

    public String getType() {
        return type;
    }
}
