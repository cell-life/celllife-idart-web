package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EntrySiteCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EntrySiteService {

    Boolean exists(EntrySiteCode entrySiteCode)

    EntrySite save(EntrySite entrySite)

    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode)

}
