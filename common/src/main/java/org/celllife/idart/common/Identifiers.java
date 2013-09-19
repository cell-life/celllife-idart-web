package org.celllife.idart.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h40
 */
public final class Identifiers implements Serializable {

    public static Identifier newIdentifier(String value) {

        return newIdentifier(Systems.IDART_WEB.id, value);
    }

    public static Identifier newIdentifier(SystemId system, String value) {

        Identifier identifier = new Identifier();
        identifier.setSystem(system);
        identifier.setValue(value);

        return identifier;
    }

    public static String getIdentifierValue(Set<Identifier> identifiers, SystemId systemId) {

        for (Identifier identifier : identifiers) {
            if (identifier.getSystem().equals(systemId)) {
                return identifier.getValue();
            }
        }

        return null;
    }

    public static Set<Identifier> newIdentifiers(SystemId system, String value) {

        Set<Identifier> identifiers = new HashSet<Identifier>();
        identifiers.add(newIdentifier(system, value));

        return identifiers;
    }

    public static Set<Identifier> newIdentifiers(String value) {
        return newIdentifiers(Systems.IDART_WEB.id, value);
    }
}
