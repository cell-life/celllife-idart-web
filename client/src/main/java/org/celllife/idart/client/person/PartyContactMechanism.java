package org.celllife.idart.client.person;

import java.io.Serializable;
import java.util.Date;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h42
 */
public final class PartyContactMechanism implements Serializable {

    public Date fromDate;

    public Date thruDate;

    public Boolean nonSolicitationIndicator;

    public String extension;

    public String comment;

    public ContactMechanism contactMechanism;

    public PartyContactMechanism() {
    }
}
