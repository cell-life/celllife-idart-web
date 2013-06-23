package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.LocalisedText;
import org.celllife.idart.domain.concept.Names;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect NameableAspect {

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Names Nameable.names = new Names();

    public Set<LocalisedText> Nameable.getNames() {
        return names.getNames();
    }

    public void Nameable.setNames(Set<LocalisedText> names) {
        this.names.setNames(names);
    }

    public String Nameable.getName() {
        return this.names.getName();
    }

    public void Nameable.setName(String name) {
        this.names.setName(name);
    }

    public void Nameable.addName(String name) {
        this.names.addName(name);
    }

    public void Nameable.addName(String locale, String name) {
        this.names.addName(locale, name);
    }
}
