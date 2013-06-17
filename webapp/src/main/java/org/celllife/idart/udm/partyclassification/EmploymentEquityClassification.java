package org.celllife.idart.udm.partyclassification;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h44
 */
@Entity
@DiscriminatorValue("EmploymentEquityClassification")
public final class EmploymentEquityClassification extends PersonClassification {

    public EmploymentEquityClassification() {
    }

}
