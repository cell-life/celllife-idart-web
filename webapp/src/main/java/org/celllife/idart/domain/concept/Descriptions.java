package org.celllife.idart.domain.concept;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 15h54
 */
@Entity
public final class Descriptions extends BaseEntity {

    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<LocalisedText> descriptions;

    public String getDescription() {
        for (LocalisedText localisedText : descriptions) {
            if (localisedText.getLocale().equals("en")) {
                return localisedText.getValue();
            }
        }
        return null;
    }

    public void setDescription(String description) {
        this.addDescription(description);
    }

    public void addDescription(String description) {
        this.addDescription("en", description);
    }

    public void addDescription(String locale, String description) {

        if (description == null) {
            return;
        }

        if (this.descriptions == null) {
            this.descriptions = new HashSet<>();
        }

        this.descriptions.add(new LocalisedText(locale, description));
    }
}
