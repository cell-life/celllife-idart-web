package org.celllife.idart.udm.codedconcept;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Entity
@DiscriminatorValue("AdministrationMethod")
public final class AdministrationMethod extends CodedConcept {

    public AdministrationMethod() {
    }

}
