package org.celllife.idart.client.visit;

import org.celllife.idart.client.common.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class Encounter implements Serializable {

    public Set<Id> ids = new HashSet<Id>();

    public Encounter() {
    }
}
