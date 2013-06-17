package org.celllife.idart.udm.part;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h19
 */
@Entity
@DiscriminatorValue("RawMaterial")
public final class RawMaterial extends Part {

    public RawMaterial() {
    }

    public RawMaterial(String name) {
        super(name);
    }

}
