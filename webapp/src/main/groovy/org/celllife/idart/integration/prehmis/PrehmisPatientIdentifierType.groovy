package org.celllife.idart.integration.prehmis

import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h22
 */
enum PrehmisPatientIdentifierType {

    PGWC(SystemId.PGWC, "PGWC Patient Number"),

    PREHMIS(SystemId.PREHMIS, "PREHMIS ID"),

    SAID(SystemId.SA_IDENTITY_NUMBER, "National ID Number"),

    PASSPORT(SystemId.SA_PASSPART_NUMBER, "Passport Number")

    final SystemId system

    final String description

    PrehmisPatientIdentifierType(SystemId system, String description) {
        this.system = system
        this.description = description
    }

    String getDescription() {
        return this.description
    }

    SystemId getSystem() {
        return this.system
    }
}
