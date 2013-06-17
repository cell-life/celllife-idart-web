package org.celllife.idart.udm.partyclassification;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 12h07
 */
@Entity
@DiscriminatorValue("StandardIndustrialClassification")
public final class StandardIndustrialClassification extends OrganisationClassification {

    public StandardIndustrialClassification() {
    }

}
