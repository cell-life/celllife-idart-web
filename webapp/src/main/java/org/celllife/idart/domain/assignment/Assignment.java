package org.celllife.idart.domain.assignment;

import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.domain.doctor.Doctor;
import org.celllife.idart.domain.clinic.Clinic;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h38
 */
@Entity
public final class Assignment implements Persistable, Serializable {

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Clinic clinic;

    public Assignment() {
    }

    public Assignment(Doctor doctor, Clinic clinic) {
        this.doctor = doctor;
        this.clinic = clinic;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
}
