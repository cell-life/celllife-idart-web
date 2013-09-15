package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Authority Id
 *
 */
@EqualsAndHashCode
class AuthorityId implements Serializable {

    public static final AuthorityId IDART = valueOf("IDART")

    public static final AuthorityId PREHMIS = valueOf("PREHMIS")

    public static final AuthorityId PGWC = valueOf("PGWC")

    public static final AuthorityId SA_IDENTITY_NUMBER = valueOf("SA_IDENTITY_NUMBER")

    public static final AuthorityId SA_PASSPART_NUMBER = valueOf("SA_PASSPART_NUMBER")

    /**
     * Value
     */
    String value
    
    static AuthorityId valueOf(String string) {
        new AuthorityId ( value: string )
    }

    static AuthorityId newAuthorityId(String string) {
        new AuthorityId ( value: string )
    }
    
    @JsonValue
    String getValue() {
         this.value
    }

    def setValue(String value) {
         this.value = value
    }
    
    @Override
    String toString() {
         value 
    }
}
