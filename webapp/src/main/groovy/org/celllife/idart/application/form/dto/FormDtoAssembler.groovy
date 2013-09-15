package org.celllife.idart.application.form.dto

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormDtoAssembler {

    static Form toForm(FormDto formDto) {

        def form = new Form()
        form.with {

        }

        form
    }

    static FormDto toFormDto(Form form) {

        def formDto = new FormDto()
        formDto.with {

        }

        formDto
    }
}
