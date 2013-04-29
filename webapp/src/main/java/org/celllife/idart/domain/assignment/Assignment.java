package org.celllife.idart.domain.assignment;

import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.doctor.Doctor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h38
 */
@Entity
public final class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
