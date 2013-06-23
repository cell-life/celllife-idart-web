package org.celllife.idart.interfaces.service.patient;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 10h55
 */
public final class FindPatientsByIdentifierRequest implements Serializable {

    private String patientIdentifier;

    private String clinicIdentifier;

    public FindPatientsByIdentifierRequest() {
    }

    public String getPatientIdentifier() {
        return patientIdentifier;
    }

    public void setPatientIdentifier(String patientIdentifier) {
        this.patientIdentifier = patientIdentifier;
    }

    public String getClinicIdentifier() {
        return clinicIdentifier;
    }

    public void setClinicIdentifier(String clinicIdentifier) {
        this.clinicIdentifier = clinicIdentifier;
    }
}
