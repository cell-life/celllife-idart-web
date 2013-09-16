package org.celllife.idart.application.form

import org.celllife.idart.application.form.dto.FormDto
import org.celllife.idart.common.FormCode
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FormApplicationService {

    Boolean exists(FormCode formCode)

    FormCode save(FormDto formDto)

    FormDto findByFormCode(FormCode formCode)

    FormDto findByIdentifier(Identifier identifier)

    FormCode findByIdentifiers(Set<Identifier> identifiers)

}
