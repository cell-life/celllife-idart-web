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

    private String type;

    public PatientIdentifier() {
    }

    PatientIdentifier(String value, String type) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientIdentifier that = (PatientIdentifier) o;

        if (type != that.type) return false;
        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + type.hashCode();
        return result;
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
