package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.LocalisedText;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect DescribableAspect {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<LocalisedText> Codeable.descriptions = new HashSet<>();

    public String Codeable.getDescription() {
        for (LocalisedText localisedText : descriptions) {
            if (localisedText.getLocale().equals("en")) {
                return localisedText.getValue();
            }
        }
        return null;
    }

    public void Codeable.setDescription(String description) {
        this.addDescription(description);
    }

    public void Codeable.addDescription(String description) {
        this.addDescription("en", description);
    }

    public void Codeable.addDescription(String locale, String description) {

        if (description == null) {
            return;
        }

        if (this.descriptions == null) {
            this.descriptions = new HashSet<>();
        }

        this.descriptions.add(new LocalisedText(locale, description));
    }
}
