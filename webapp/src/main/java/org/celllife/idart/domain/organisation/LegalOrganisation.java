package org.celllife.idart.domain.organisation;

import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h52
 */
public final class LegalOrganisation extends Organisation {

    private String taxRegistrationNumber;

    public LegalOrganisation() {
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }
}
