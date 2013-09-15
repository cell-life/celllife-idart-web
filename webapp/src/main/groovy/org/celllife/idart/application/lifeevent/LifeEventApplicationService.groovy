package org.celllife.idart.application.lifeevent

import org.celllife.idart.application.lifeevent.dto.LifeEventDto
import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface LifeEventApplicationService {

    Boolean exists(LifeEventCode lifeEventCode)

    LifeEventCode save(LifeEventDto lifeEventDto)

    LifeEventDto findByLifeEventCode(LifeEventCode lifeEventCode)

    LifeEventDto findByIdentifier(Identifier identifier)

}
