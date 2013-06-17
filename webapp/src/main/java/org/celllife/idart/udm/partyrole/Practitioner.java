package org.celllife.idart.udm.partyrole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
@Entity
@DiscriminatorValue("Practitioner")
public final class Practitioner extends PersonRole {

    public Practitioner() {
    }

}
