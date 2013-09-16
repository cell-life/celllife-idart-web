package org.celllife.idart.client.substitution;

import org.celllife.idart.common.SubstitutionCode;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h56
 */
public final class Substitution implements Serializable {

    public SubstitutionCode code;

    public String name;

    public String description;

    public Substitution() {
    }
}
