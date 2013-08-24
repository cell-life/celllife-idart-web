package org.celllife.idart.application.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.common.EntrySiteCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface EntrySiteApplicationService {

    EntrySite save(EntrySite entrySite) throws EntrySiteValidationException

    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode) throws EntrySiteNotFoundException

}
