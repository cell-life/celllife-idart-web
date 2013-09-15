package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EntrySiteCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EntrySiteRepository {

    boolean exists(EntrySiteCode entrySiteCode)

    EntrySite save(EntrySite entrySite)

    EntrySite findOne(EntrySiteCode entrySiteCode)

}
