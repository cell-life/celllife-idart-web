package org.celllife.idart.domain.concept;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 15h54
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Names extends BaseEntity {

    @NotNull
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<LocalisedText> names;

    public Set<LocalisedText> getNames() {
        return names;
    }

    public void setNames(Set<LocalisedText> names) {
        this.names = names;
    }

    public String getName() {
        for (LocalisedText localisedText : names) {
            if (localisedText.getLocale().equals("en")) {
                return localisedText.getValue();
            }
        }
        return null;
    }

    public void setName(String name) {
        this.addName(name);
    }

    public void addName(String name) {
        this.addName("en", name);
    }

    public void addName(String locale, String name) {

        if (name == null) {
            return;
        }

        if (this.names == null) {
            this.names = new HashSet<>();
        }
        this.names.add(new LocalisedText(locale, name));
    }
}
