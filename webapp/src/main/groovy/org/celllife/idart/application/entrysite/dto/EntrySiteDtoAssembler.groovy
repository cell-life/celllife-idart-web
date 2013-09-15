package org.celllife.idart.application.entrysite.dto

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteDtoAssembler {

    static EntrySite toEntrySite(EntrySiteDto entrySiteDto) {

        def entrySite = new EntrySite()
        entrySite.with {

        }

        entrySite
    }

    static EntrySiteDto toEntrySiteDto(EntrySite entrySite) {

        def entrySiteDto = new EntrySiteDto()
        entrySiteDto.with {

        }

        entrySiteDto
    }
}
