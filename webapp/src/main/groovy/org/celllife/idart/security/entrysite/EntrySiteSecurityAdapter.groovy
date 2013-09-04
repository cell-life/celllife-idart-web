package org.celllife.idart.security.entrysite

import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.application.entrysite.EntrySiteApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteSecurityAdapter {

    @Inject EntrySiteApplicationService entrySiteApplicationService

    EntrySite save(Principal principal, EntrySite entrySite) {
        entrySiteApplicationService.save(entrySite)
    }

    EntrySite findByEntrySiteCode(Principal principal, EntrySiteCode entrySiteCode) {
        entrySiteApplicationService.findByEntrySiteCode(entrySiteCode)
    }

}
