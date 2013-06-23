package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Descriptions;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect DescribableAspect {

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Descriptions Describable.descriptions = new Descriptions();

    public String Describable.getDescription() {
        return this.descriptions.getDescription();
    }

    public void Describable.setDescription(String description) {
        this.descriptions.setDescription(description);
    }

    public void Describable.addDescription(String description) {
        this.descriptions.addDescription(description);
    }

    public void Describable.addDescription(String locale, String description) {
        this.descriptions.addDescription(locale, description);
    }
}
