package org.celllife.idart.domain.entrysite

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EntrySiteRepository {

    EntrySite save(EntrySite entrySite)

    EntrySite findOne(EntrySiteCode code)

}
