package org.celllife.idart.application.entrysite

import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.entrysite.EntrySite

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface EntrySiteApplicationService {

    EntrySite save(EntrySite entrySite)

    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode)

}
