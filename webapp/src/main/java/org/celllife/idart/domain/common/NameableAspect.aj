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
privileged aspect NameableAspect {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<LocalisedText> Nameable.names = new HashSet<>();

    public Set<LocalisedText> Nameable.getNames() {
        return names;
    }

    public void Nameable.setNames(Set<LocalisedText> names) {
        this.names = names;
    }

    public String Nameable.getName() {
        for (LocalisedText localisedText : names) {
            if (localisedText.getLocale().equals("en")) {
                return localisedText.getValue();
            }
        }
        return null;
    }

    public void Nameable.setName(String name) {
        this.addName(name);
    }

    public void Nameable.addName(String name) {
        this.addName("en", name);
    }

    public void Nameable.addName(String locale, String name) {

        if (name == null) {
            return;
        }

        if (this.names == null) {
            this.names = new HashSet<>();
        }
        this.names.add(new LocalisedText(locale, name));
    }
}
