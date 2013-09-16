package org.celllife.idart.application.entrysite.dto

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteDtoAssembler {

    EntrySite toEntrySite(EntrySiteDto entrySiteDto) {

        def entrySite = new EntrySite()
        entrySite.with {

        }

        entrySite
    }

    EntrySiteDto toEntrySiteDto(EntrySite entrySite) {

        def entrySiteDto = new EntrySiteDto()
        entrySiteDto.with {

        }

        entrySiteDto
    }
}
