package org.celllife.idart.client.common;

import java.io.Serializable;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h29
 */
public final class Coded implements Serializable {

    public Set<Code> codes;

    public Coded() {
    }

    @Override
    public String toString() {
        return "Coded{" +
                "codes=" + codes +
                '}';
    }
}
