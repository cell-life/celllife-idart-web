package org.celllife.idart.integration.prehmis;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
public enum PrehmisPatientIdentifierType {

    PGWC("pgwc", "PGWC Patient Number"),

    PREHMIS("prehmis", "PREHMIS ID"),

    SAID("said", "National ID Number"),

    PASSPORT("passport", "Passport Number");

    private String prehmisType;

    private String idartType;

    PrehmisPatientIdentifierType(String prehmisType, String idartType) {

        this.prehmisType = prehmisType;
        this.idartType = idartType;
    }

    public String getPrehmisType() {
        return prehmisType;
    }

    public String getIdartType() {
        return idartType;
    }
}
