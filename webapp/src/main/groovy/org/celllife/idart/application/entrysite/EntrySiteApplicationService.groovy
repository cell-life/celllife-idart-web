package org.celllife.idart.application.entrysite

import org.celllife.idart.application.entrysite.dto.EntrySiteDto
import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface EntrySiteApplicationService {

    Boolean exists(EntrySiteCode entrySiteCode)

    EntrySiteCode save(EntrySiteDto entrySiteDto)

    EntrySiteDto findByEntrySiteCode(EntrySiteCode entrySiteCode)

    EntrySiteDto findByIdentifier(Identifier identifier)

    EntrySiteCode findByIdentifiers(Set<Identifier> identifiers)

}
