package org.celllife.idart.application.entrysite

import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteApplicationServiceImpl implements EntrySiteApplicationService {

    @Inject EntrySiteService entrySiteService

    EntrySite save(EntrySite entrySite) {
        entrySiteService.save(entrySite)
    }

    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode) {
        entrySiteService.findByEntrySiteCode(entrySiteCode)
    }

}
