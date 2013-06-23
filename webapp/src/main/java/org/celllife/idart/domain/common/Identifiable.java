package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Identifier;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 23h17
 */
public interface Identifiable {

    Set<Identifier> getIdentifiers();

    void setIdentifiers(Set<Identifier> identifiers);

    void addIdentifier(String system, String value);

    String getFirstSystem();

    String getIdentifierValue(String system);

    Set<String> getIdentifierSystems();

    boolean hasIdentifierForSystem(String system);

    void mergeIdentifiers(Identifiable that);
}
