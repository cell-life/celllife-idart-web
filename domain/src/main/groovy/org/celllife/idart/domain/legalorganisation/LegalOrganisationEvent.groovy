package org.celllife.idart.domain.legalorganisation

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Legal Organisation Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LegalOrganisationEvent {

    EventHeader header

    LegalOrganisation legalOrganisation

    static LegalOrganisationEvent newLegalOrganisationEvent(LegalOrganisation legalOrganisation, LegalOrganisationEvent.EventType eventType) {
        new LegalOrganisationEvent(legalOrganisation: legalOrganisation, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
