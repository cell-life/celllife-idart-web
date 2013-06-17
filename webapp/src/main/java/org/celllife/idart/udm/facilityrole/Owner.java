package org.celllife.idart.udm.facilityrole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 20h42
 */
@Embeddable
@DiscriminatorValue("Owner")
public final class Owner extends PartyRoleFacility {

    public Owner() {
    }

}
