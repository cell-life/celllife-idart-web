package org.celllife.idart.domain.doctor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 10h44
 */
@Entity
public final class DoctorIdentifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String value;

    @Enumerated(EnumType.STRING)
    private DoctorIdentifierType type;

    public DoctorIdentifier() {
    }

    DoctorIdentifier(String value, DoctorIdentifierType type) {
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

    public DoctorIdentifierType getType() {
        return type;
    }

    public void setType(DoctorIdentifierType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorIdentifier that = (DoctorIdentifier) o;

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
}
