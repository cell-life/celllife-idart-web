package org.celllife.idart.domain.clinic;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h43
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"value", "type"}))
public final class ClinicIdentifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic
    private String value;

    @Enumerated(EnumType.STRING)
    private ClinicIdentifierType type;

    public ClinicIdentifier() {
    }

    ClinicIdentifier(String value, ClinicIdentifierType type) {
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

    public ClinicIdentifierType getType() {
        return type;
    }

    public void setType(ClinicIdentifierType type) {
        this.type = type;
    }
}
