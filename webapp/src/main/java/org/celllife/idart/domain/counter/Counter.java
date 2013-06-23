package org.celllife.idart.domain.counter;

import org.celllife.idart.domain.common.Persistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
@Entity
public final class Counter implements Persistable, Serializable {

    @Column(unique = true)
    private String name;

    private Integer value;

    public Counter() {
    }

    public Counter(String name) {
        this.name = name;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer nextValue() {
        return value++;
    }
}
