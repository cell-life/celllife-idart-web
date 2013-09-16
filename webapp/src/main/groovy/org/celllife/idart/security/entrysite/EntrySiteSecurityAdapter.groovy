package org.celllife.idart.security.entrysite

import org.celllife.idart.application.entrysite.dto.EntrySiteDto
import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.common.Identifier
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

    EntrySiteCode save(Principal principal, entrySiteDto) {
        entrySiteApplicationService.save(entrySiteDto)
    }

    EntrySiteDto findByEntrySiteCode(Principal principal, EntrySiteCode entrySiteCode) {
        entrySiteApplicationService.findByEntrySiteCode(entrySiteCode)
    }

    EntrySiteDto findByIdentifier(Principal principal, Identifier identifier) {
        entrySiteApplicationService.findByIdentifier(identifier)
    }

}
