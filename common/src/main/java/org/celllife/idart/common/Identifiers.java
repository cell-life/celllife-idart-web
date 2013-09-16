package org.celllife.idart.common;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h40
 */
public final class Identifiers implements Serializable {

    public static Identifier newIdentifier(AuthorityId authority, String value) {

        Identifier identifier = new Identifier();
        identifier.setAuthority(authority);
        identifier.setValue(value);

        return identifier;
    }

    public static String getIdentifierValue(Set<Identifier> identifiers, AuthorityId authorityId) {

        for (Identifier identifier : identifiers) {
            if (identifier.getAuthority().equals(authorityId)) {
                return identifier.getValue();
            }
        }

        return null;
    }

}
