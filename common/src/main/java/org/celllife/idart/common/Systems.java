package org.celllife.idart.common;

import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 14h07
 */
public enum Systems {

    IDART_WEB(systemId("IDART_WEB")),

    PREHMIS(systemId("PREHMIS")),

    PGWC(systemId("PGWC")),

    SA_IDENTITY_NUMBER(systemId("SA_IDENTITY_NUMBER")),

    SA_PASSPART_NUMBER(systemId("SA_PASSPART_NUMBER"));

    public SystemId id;

    Systems(SystemId id) {
        this.id = id;
    }
}
