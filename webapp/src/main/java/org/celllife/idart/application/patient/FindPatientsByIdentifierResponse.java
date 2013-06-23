package org.celllife.idart.application.patient;


import org.celllife.idart.domain.patient.Patient;

import java.io.Serializable;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 11h44
 */
public final class FindPatientsByIdentifierResponse implements Serializable {

    private List<Patient> patients;

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
