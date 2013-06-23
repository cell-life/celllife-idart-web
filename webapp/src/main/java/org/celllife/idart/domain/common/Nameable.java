package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.LocalisedText;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 23h11
 */
public interface Nameable {

    Set<LocalisedText> getNames();

    void setNames(Set<LocalisedText> names);

    String getName();

    void setName(String name);

    void addName(String name);

    void addName(String locale, String name);
}
