package org.celllife.idart.infrastructure.camel.legalorganisation

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.legalorganisation.LegalOrganisationEvent
import org.celllife.idart.domain.legalorganisation.LegalOrganisationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Legal Organisation Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelLegalOrganisationEventPublisher implements LegalOrganisationEventPublisher {

    @EndpointInject(uri = "direct:legalOrganisationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(LegalOrganisationEvent legalOrganisationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(legalOrganisationEvent))
    }
}
