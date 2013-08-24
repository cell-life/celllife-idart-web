package org.celllife.idart.client.clinic;

import org.celllife.idart.client.common.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2013-07-18
 * Time: 20h25
 */
public final class Clinic implements Serializable {

    public Set<Id> ids;

    public Clinic() {
    }

    public void addId(String system, String value) {
        if (this.ids == null) {
            this.ids = new HashSet<Id>();
        }
        this.ids.add(new Id(system, value));
    }

}
