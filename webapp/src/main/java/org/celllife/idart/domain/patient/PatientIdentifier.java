package org.celllife.idart.domain.patient;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h43
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"value", "type"}))
public final class PatientIdentifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic
    private String value;

    @Enumerated(EnumType.STRING)
    private PatientIdentifierType type;

    public PatientIdentifier() {
    }

    PatientIdentifier(String value, PatientIdentifierType type) {
        this.value = value;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PatientIdentifierType getType() {
        return type;
    }

    public void setType(PatientIdentifierType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PatientIdentifier{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
