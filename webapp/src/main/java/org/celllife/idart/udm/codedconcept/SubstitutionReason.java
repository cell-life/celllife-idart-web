package org.celllife.idart.udm.codedconcept;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h58
 */
@Entity
@DiscriminatorValue("SubstitutionReason")
public final class SubstitutionReason extends CodedConcept {

    public SubstitutionReason() {
    }
}
