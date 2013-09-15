package org.celllife.idart.integration.prehmis

import org.celllife.idart.common.AuthorityId

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
enum PrehmisPatientIdentifierType {

    PGWC(AuthorityId.PGWC, "PGWC Patient Number"),

    PREHMIS(AuthorityId.PREHMIS, "PREHMIS ID"),

    SAID(AuthorityId.SA_IDENTITY_NUMBER, "National ID Number"),

    PASSPORT(AuthorityId.SA_PASSPART_NUMBER, "Passport Number")

    final AuthorityId authority

    final String description

    PrehmisPatientIdentifierType(AuthorityId authority, String description) {
        this.authority = authority
        this.description = description
    }

    String getDescription() {
        return this.description
    }

    AuthorityId getAuthority() {
        return this.authority
    }
}
