package org.celllife.idart.domain.product;

import org.celllife.idart.domain.common.Nameable;
import org.celllife.idart.domain.common.Persistable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product implements Persistable, Nameable {

    protected Product() {
    }

    public Product(String name) {
        addName(name);
    }
}
