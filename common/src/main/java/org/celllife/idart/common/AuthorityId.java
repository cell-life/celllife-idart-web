package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Authority Id
 */
public final class AuthorityId implements Serializable {

    public static final AuthorityId IDART = valueOf("IDART");

    public static final AuthorityId PREHMIS = valueOf("PREHMIS");

    public static final AuthorityId PGWC = valueOf("PGWC");

    public static final AuthorityId SA_IDENTITY_NUMBER = valueOf("SA_IDENTITY_NUMBER");

    public static final AuthorityId SA_PASSPART_NUMBER = valueOf("SA_PASSPART_NUMBER");

    /**
     * Value
     */
    private String value;

    public static AuthorityId valueOf(String string) {
        return newAuthorityId(string);
    }

    public static AuthorityId newAuthorityId(String value) {

        AuthorityId authorityId = new AuthorityId();
        authorityId.value = value;

        return authorityId;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityId that = (AuthorityId) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return getValue();
    }
}
