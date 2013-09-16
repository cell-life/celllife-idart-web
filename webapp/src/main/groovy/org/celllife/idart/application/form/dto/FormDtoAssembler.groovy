package org.celllife.idart.application.form.dto

import org.celllife.idart.domain.form.Form
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FormDtoAssembler {

    Form toForm(FormDto formDto) {

        def form = new Form()
        form.with {

        }

        form
    }

    FormDto toFormDto(Form form) {

        def formDto = new FormDto()
        formDto.with {

        }

        formDto
    }
}
