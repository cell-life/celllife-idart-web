package org.celllife.idart.domain.counter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
@Entity
public final class Counter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer value;

    public Counter() {
    }

    public Counter(String name) {
        this.name = name;
        this.value = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
